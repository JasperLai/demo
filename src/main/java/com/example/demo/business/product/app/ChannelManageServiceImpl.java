package com.example.demo.business.product.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.business.general.app.dto.TransactionDTO;
import com.example.demo.business.general.client.TMSInterface;
import com.example.demo.business.general.client.TradeType;
import com.example.demo.business.general.client.TransStatus;
import com.example.demo.business.general.client.OrganizationService;
import com.example.demo.business.product.app.dto.request.TraderDTO;
import com.example.demo.business.product.app.dto.request.QuotaTransferDTO;
import com.example.demo.business.product.app.dto.response.InventoryDTO;
import com.example.demo.business.product.client.ChannelManageService;
import com.example.demo.business.product.domain.entity.Inventory;
import com.example.demo.business.product.domain.repository.InventoryRepository;
import com.example.demo.business.product.domain.service.InventoryService;
import com.example.demo.common.catchall.CatchAndLog;
import com.example.demo.common.exception.data.ListData;
import com.example.demo.common.response.Response;

import java.util.List;

@Service
@CatchAndLog
public class ChannelManageServiceImpl implements ChannelManageService {

    @Autowired
    private InventoryService inventoryService;
    
    @Autowired
    private InventoryRepository inventoryRepository;
    
    @Autowired
    private TMSInterface transactionManageService;
    
    @Autowired
    private OrganizationService organizationService;

    @Override
    public void bondQuotaBatchTransfer(String bondCode, String outOrg, List<QuotaTransferDTO> transferList,
            TransactionDTO transactionVO) {
        // 创建交易记录
        String transID = transactionManageService.createTransaction(transactionVO, TradeType.BOND_QUOTA_TRANSFER); 
            // 获取实际的源库存记录
        Inventory actualOutInventory = getEffectiveInventory(bondCode, outOrg);
        if (actualOutInventory == null) {
            throw new IllegalArgumentException("调出机构没有可用额度");
        }
        
        // 计算总调拨额度
        long totalAmount = transferList.stream().mapToLong(QuotaTransferDTO::getAmount).sum();
        if (actualOutInventory.getLimits() < totalAmount) {
            throw new IllegalArgumentException("调出机构可度不足");
        }
        
        // 处理每个调拨请求
        for (QuotaTransferDTO transfer : transferList) {
            transferQuota(bondCode, transfer.getAmount(), outOrg, transfer.getOrgId());
        }
            
       
    }

    @Override
    @Transactional
    public void bondQuotaTransfer(String outOrg, String inOrg, long amount, String bondCode) {
        transferQuota(bondCode, amount, outOrg, inOrg);
    }

    /**
     * 执行额度调拨
     */
    private void transferQuota(String bondCode, long amount, String outOrg, String inOrg) {
        // 基础参数校验
        if (bondCode == null || outOrg == null || inOrg == null || amount <= 0) {
            throw new IllegalArgumentException("调拨参数不合法");
        }
        
        // 检查机构层级合法性
        validateOrgHierarchy(outOrg, inOrg);
        
        // 获取实际的源库存记录
        Inventory actualOutInventory = getEffectiveInventory(bondCode, outOrg);
        if (actualOutInventory == null) {
            throw new IllegalArgumentException("调出机构没有可用额度");
        }
        
        // 获取或创建目标机构的库存记录
        Inventory inInventory = inventoryRepository.findByProductIdAndOrgNum(bondCode, inOrg);
        if (inInventory == null) {
            inInventory = Inventory.builder()
                    .withBondCode(bondCode)
                    .withOrgNum(inOrg)
                    .withLimits(0L)
                    .withSaleStrategy(Inventory.SaleStrategy.specific)
                    .build();
        }
        
        // 执行调拨
        inventoryService.transferInventory(actualOutInventory, inInventory, amount);
    }

    @Override
    public Response<InventoryDTO> queryQuota(String bondCode, String orgNum) {
        // 参数校验
        if (bondCode == null || orgNum == null) {
            throw new IllegalArgumentException("债券代码和机构编号不能为空");
        }
        
        // 获取机构层级
        int orgLevel = organizationService.getOrgLevel(orgNum);
        
        // 如果是总行级别，需要计算所有下属分行的可用额度总和
        if (orgLevel == 1) {  // 1=总行
            Inventory headOfficeInventory = inventoryRepository.findByProductIdAndOrgNum(bondCode, orgNum);
            if (headOfficeInventory == null) {
                return Response.error("未找到可用额度信息");
            }
            
            // 获取该总行下所有独立额度的分行库存记录
            List<Inventory> branchInventories = inventoryRepository.findByProductId(bondCode);
            
            // 计算已分配给分行的固定额度总和
            long allocatedAmount = branchInventories.stream()
                    .filter(inv -> inv.getSaleStrategy() == Inventory.SaleStrategy.specific)
                    .mapToLong(Inventory::getLimits)
                    .sum();
            
            // 总行实际可用额度 = 总行库存 - 已分配给分行的固定额度
            long availableAmount = headOfficeInventory.getLimits() - allocatedAmount;
            
            // 构建返回结果
            InventoryDTO dto = InventoryDTO.fromEntity(headOfficeInventory);
            dto.setLimits(availableAmount);  // 更新为实际可用额度
            return Response.success(dto);
        }
        
        // 对于分行和支行，先查询本机构是否有独立额度
        Inventory inventory = inventoryRepository.findByProductIdAndOrgNum(bondCode, orgNum);
        if (inventory != null && inventory.getSaleStrategy() == Inventory.SaleStrategy.specific) {
            // 有独立额度，直接返回
            return Response.success(InventoryDTO.fromEntity(inventory));
        }
        
        // 没有独立额度或是共享模式，向上查找可用额度
        String parentOrg = organizationService.getParentOrg(orgNum);
        if (parentOrg == null) {
            return Response.error("未找到可用额度信息");
        }
        
        Inventory parentInventory = getEffectiveInventory(bondCode, parentOrg);
        if (parentInventory == null) {
            return Response.error("未找到可用额度信息");
        }
        
        // 转换为DTO，并标记为共享模式
        InventoryDTO dto = InventoryDTO.fromEntity(parentInventory);
        dto.setSaleStrategy(Inventory.SaleStrategy.global.name());
        
        return Response.success(dto);
    }

    /**
     * 获取机构的实际有效库存（考虑共享策略）
     */
    private Inventory getEffectiveInventory(String bondCode, String orgNum) {
        if (bondCode == null || orgNum == null) {
            throw new IllegalArgumentException("bondCode和orgNum不能为空");
        }
        
        // 先查询本机构是否有独立额度
        Inventory inventory = inventoryRepository.findByProductIdAndOrgNum(bondCode, orgNum);
        if (inventory != null && inventory.getSaleStrategy() == Inventory.SaleStrategy.specific) {
            return inventory;
        }
        
        // 没有独立额度或是共享模式，查找上级机构
        String parentOrg = organizationService.getParentOrg(orgNum);
        if (parentOrg != null) {
            return getEffectiveInventory(bondCode, parentOrg);
        }
        
        return null;
    }
    
    /**
     * 验证机构层级关系
     */
    private void validateOrgHierarchy(String outOrg, String inOrg) {
        int outOrgLevel = organizationService.getOrgLevel(outOrg);
        int inOrgLevel = organizationService.getOrgLevel(inOrg);
        
        if (outOrgLevel > 2) { // 1=总行, 2=分行, 3=支行
            throw new IllegalArgumentException("调出方机构必须是总行或分行");
        }
        
        if (inOrgLevel < 2) {
            throw new IllegalArgumentException("调入方机构必须是分行或支行");
        }
    }

    

    // Public methods for trader services
    @Override
    public void addTrader(TraderDTO vo) {
        // Business logic for adding a trader
    }

    @Override
    public void deleteTrader(String agentCode) {
        // Business logic for deleting a trader
    }

    @Override
    public void storeTrader(TraderDTO vo) {
        // Business logic for storing/updating a trader
    }

    @Override
    public TraderDTO queryTrader(String agentCode) {
        // Business logic for querying a trader
        // Returning a placeholder response for now
        return new TraderDTO();
    }

    @Override
    public ListData<TraderDTO> queryTraderList(TraderDTO vo) {
        // Business logic for querying trader list
        // Returning a placeholder response for now
        return new ListData<>();
    }

    @Override
    @Transactional
    public void updateInventory(String bondCode, String orgNum, long amount, String type) {
        if (bondCode == null || orgNum == null || amount <= 0) {
            throw new IllegalArgumentException("参数不能为空且金额必须大于0");
        }

        TradeType tradeType = TradeType.getByCode(type);
        switch (tradeType) {
            case BANK_BUY:
                handleBankBuy(bondCode, orgNum, amount);
                break;
            case BANK_SELL:
                handleBankSell(bondCode, orgNum, amount);
                break;
            default:
                throw new IllegalArgumentException("不支持的交易类型");
        }
    }

    /**
     * 处理银行买入交易
     * 银行买入时，额度统一归于总行
     */
    private void handleBankBuy(String bondCode, String orgNum, long amount) {
        // 获取总行机构号
        String currentOrg = orgNum;
        String parentOrg;
        while ((parentOrg = organizationService.getParentOrg(currentOrg)) != null) {
            currentOrg = parentOrg;
        }
        String headOffice = currentOrg;

        // 获取或创建总行库存记录
        Inventory headInventory = inventoryRepository.findByProductIdAndOrgNum(bondCode, headOffice);
        if (headInventory == null) {
            headInventory = Inventory.builder()
                    .withBondCode(bondCode)
                    .withOrgNum(headOffice)
                    .withLimits(amount)
                    .withSaleStrategy(Inventory.SaleStrategy.specific)
                    .build();
            inventoryRepository.save(headInventory);
        } else {
            headInventory.setLimits(headInventory.getLimits() + amount);
            inventoryRepository.update(headInventory);
        }
    }

    /**
     * 处理银行卖出交易
     * 银行卖出时，需要考虑共享模式
     */
    private void handleBankSell(String bondCode, String orgNum, long amount) {
        // 获取实际的库存记录（考虑共享策略）
        Inventory effectiveInventory = getEffectiveInventory(bondCode, orgNum);
        if (effectiveInventory == null) {
            throw new IllegalArgumentException("未找到可用额度");
        }

        // 检查额度是否充足
        if (effectiveInventory.getLimits() < amount) {
            throw new IllegalArgumentException("可用额度不足");
        }

        // 扣减额度
        effectiveInventory.setLimits(effectiveInventory.getLimits() - amount);
        inventoryRepository.update(effectiveInventory);
    }

}
