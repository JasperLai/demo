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
        
        try {
            // 获取实际的源库存记录
            Inventory actualOutInventory = getEffectiveInventory(bondCode, outOrg);
            if (actualOutInventory == null) {
                throw new IllegalArgumentException("调出机构没有可用额度");
            }
            
            // 计算总调拨额度
            long totalAmount = transferList.stream().mapToLong(QuotaTransferDTO::getAmount).sum();
            if (actualOutInventory.getLimits() < totalAmount) {
                throw new IllegalArgumentException("调出机构可用额度不足");
            }
            
            // 处理每个调拨请求
            for (QuotaTransferDTO transfer : transferList) {
                transferQuota(bondCode, transfer.getAmount(), outOrg, transfer.getOrgId());
            }
            
            // 更新交易状态为成功
            transactionManageService.updateTransaction(transID, TransStatus.SUCCESS);
        } catch (Exception e) {
            // 更新交易状态为失败
            transactionManageService.updateTransaction(transID, TransStatus.FAILED);
            throw e;
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
            return Response.error("债券代码和机构编号不能为空");
        }
        
        // 获取实际有效的库存记录（考虑共享策略）
        Inventory inventory = getEffectiveInventory(bondCode, orgNum);
        if (inventory == null) {
            return Response.error("未找到可用额度信息");
        }
        
        // 转换为DTO
        InventoryDTO dto = InventoryDTO.fromEntity(inventory);
        
        // 如果当前机构与实际持有额度的机构不同，说明是共享额度
        if (!orgNum.equals(inventory.getOrgNum())) {
            dto.setSaleStrategy(Inventory.SaleStrategy.global.name());
        }
        
        return Response.success(dto);
    }

    /**
     * 获取机构的实际有效库存（考虑共享策略）
     */
    private Inventory getEffectiveInventory(String bondCode, String orgNum) {
        if (bondCode == null || orgNum == null) {
            throw new IllegalArgumentException("bondCode和orgNum不能为空");
        }
        
        Inventory inventory = inventoryRepository.findByProductIdAndOrgNum(bondCode, orgNum);
        
        if (inventory == null || inventory.getSaleStrategy() == Inventory.SaleStrategy.global) {
            String parentOrg = organizationService.getParentOrg(orgNum);
            if (parentOrg != null) {
                return getEffectiveInventory(bondCode, parentOrg);
            }
            return null;
        }
        
        return inventory;
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

}
