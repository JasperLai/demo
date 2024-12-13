package com.example.demo.business.product.app;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.business.general.app.dto.TransactionDTO;
import com.example.demo.business.general.client.TMSInterface;
import com.example.demo.business.general.client.TradeType;
import com.example.demo.business.general.client.TransStatus;
import com.example.demo.business.product.adapter.request.BondRegistRequest;
import com.example.demo.business.product.app.dto.request.ProductQueryVO;
import com.example.demo.business.product.app.dto.request.ProductValidateDTO;
import com.example.demo.business.product.app.dto.request.TradeSwitchDTO;
import com.example.demo.business.product.app.dto.response.BondDTO;
import com.example.demo.business.product.app.dto.response.BondProductDTO;
import com.example.demo.business.product.client.ProductManageService;
import com.example.demo.business.product.domain.entity.Bond;
import com.example.demo.business.product.domain.entity.BondProduct;
import com.example.demo.business.product.domain.repository.BondProductRepository;
import com.example.demo.common.exception.data.BaseData;
import com.example.demo.common.exception.data.ListData;
import com.example.demo.business.product.domain.service.InventoryService;
import com.example.demo.business.product.domain.service.ProductValidateRule;
import com.example.demo.business.product.domain.service.HolidayService;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManageServiceImpl implements ProductManageService {

    @Autowired
    private BondProductRepository bondProductRepository;

    @Autowired
    private TMSInterface transactionService;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private HolidayService holidayService;

    // 录入原始债券数据全量
    @Override
    public boolean enterOriginBond(BondRegistRequest vo) {
        // 参数校验
        if (vo == null) {
            return false;
        }

        try {
            // TODO: 调用数据访问层将债券资料保存到数据库
            // 1. 检查债券是否已存在
            // 2. 如果存在则更新,不存在则新增
            // 3. 更新相关联的表数据

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public BaseData registBondProduct( BondProductDTO productDTO, TransactionDTO trans) {
        // Create a new BaseData object to store the result of the operation
        BaseData result = new BaseData();

        // Call the registBondProduct method to register the bond product
        registBondProduct(productDTO);

        // Set the success flag to true, indicating that the operation was successful
        result.setSuccess(true);

        // Set a success message to inform the user that the bond product was
        // successfully registered
        result.setReturnMsg("债券产品录入成功");

        // Return the result object containing the success status and message
        return result;
    }

    @Override
    public void registBondProduct(BondProductDTO productDTO) {
        // 1. 检查债券是否存在
        BondDTO bondDTO = queryBondDetailWithCheck(productDTO.getBondCode());
        // 2. 将债券信息转换为债券产品实体
        BondProduct bondProduct = productDTO.toRegisterEntity();
        // 3. 设置债券产品中的债券信息
        bondProduct.setBond(new Bond(bondDTO.getBondCode()));
        // 4. 保存债券产品
        bondProductRepository.saveProduct(bondProduct);
    }

    public BondDTO queryBondDetailWithCheck(String bondCode) {
        Bond bond = bondProductRepository.findBondByBondCode(bondCode);
        if (bond == null) {
            throw new RuntimeException("债券代码不存在");
        }
        return BondDTO.fromEntity(bond);
    }

    @Override
    public BaseData updateBondProduct(BondProductDTO dto, TransactionDTO trans) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBondProduct'");
    }

    @Override
    public void updateBondProduct(BondProductDTO dto) {
        // 1. 检查并获取现有产品
        BondProduct existingProduct = bondProductRepository.findByProductId(dto.getProductId());
        if (existingProduct == null) {
            throw new RuntimeException("产品不存在: " + dto.getProductId());
        }

        // 2. 更新产品信息
        existingProduct.updateFromDTO(dto);

        // 3. 保存更新后的产品
        bondProductRepository.updateProduct(existingProduct);
    }

    @Override
    public BaseData setProductSwitch(TradeSwitchDTO vo, TransactionDTO trans) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setProductSwitch'");
    }

    @Override
    public BaseData setTradeSwitch(TradeSwitchDTO vo, TransactionDTO trans) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTradeSwitch'");
    }

    @Override
    public BaseData setRenewDefaultSwitch(String productID, TransactionDTO trans) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRenewDefaultSwitch'");
    }

    @Override
    public ListData<TradeSwitchDTO> queryTradeSwitch(TradeSwitchDTO vo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'queryTradeSwitch'");
    }

    @Override
    public BaseData queryProductSwitch(String productID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'queryProductSwitch'");
    }

    @Override
    public ListData<BondProductDTO> queryProductList(ProductQueryVO vo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'queryProductList'");
    }

    @Override
    public BondProductDTO queryProductDetail(String productID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'queryProductDetail'");
    }

    @Override
    public void setRecommendBond(String productID, boolean isRecmd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setRecommendBond'");
    }

    @Override
    public void validateOrder(ProductValidateDTO validateDTO) {
        // 1. 校验交易面额
        ProductValidateRule.validateFaceAmount(validateDTO.getFaceAmount());

        // 2. 获取并校验产品信息
        BondProduct product = bondProductRepository.findByProductId(validateDTO.getProductId());
        if (product == null) {
            throw new IllegalArgumentException("产品不存在");
        }

        // 3. 校验生命周期
        ProductValidateRule.validateLifeCycle(product, validateDTO.getTradeType());

        // 4. 校验分销��限（如果是分销交易）
        if ("003".equals(validateDTO.getTradeType())) {
            ProductValidateRule.validateDistributionAuth(product);
        }

        // 5. 获取并校验最新报价
        // QuotaDTO latestQuota = getCurrentQuotation(validateDTO.getProductId());
        // ProductValidateRule.validatePrice(validateDTO.getPrice(), latestQuota);

        // 6. 校验库存
        // Inventory inventory = inventoryService.queryInventory(
        // validateDTO.getProductId(),
        // getCurrentOrgId()
        // );
        // if (inventory == null) {
        // throw new IllegalArgumentException("未找到产品库存信息");
        // }
        // ProductValidateRule.validateInventory(
        // validateDTO.getFaceAmount(),
        // inventory.getAvailableQuota()
        // );
    }

    @Override
    public List<BondDTO> queryBondsInRegistrationDate() {
        // 1. 获取所有债券产品
        List<BondProductDTO> allProductDTOs = bondProductRepository.findAll();
        
        List<BondProduct> allProducts = allProductDTOs.stream()
                .map(BondProductDTO::toEntity)
                .collect(Collectors.toList());
        // 2. 获取当前日期
        LocalDate today = LocalDate.now();
        
        // 3. 筛选处于债权登记日的债券
        return allProducts.stream()
                .map(BondProduct::getBond)  // 获取产品中的债券
                .filter(bond -> isInRegistrationDate(bond, today))  // 筛选债权登记日的债券
                .map(BondDTO::fromEntity)   // 转换为DTO
                .collect(Collectors.toList());
    }

    /**
     * 判断债券是否处于债权登记日
     * 债权登记日为下一付息日前两个工作日
     */
    private boolean isInRegistrationDate(Bond bond, LocalDate today) {
        // 获取下一付息日
        LocalDate nextCouponDate = bond.getNextCouponDate();
        if (nextCouponDate == null) {
            return false;
        }
        
        // 计算债权登记日(下一付息日前两个工作日)
        LocalDate registrationDate = calculateRegistrationDate(nextCouponDate);
        
        // 判断今天是否是债权登记日
        return today.equals(registrationDate);
    }

    /**
     * 计算债权登记日
     * 从指定日期向前推两个工作日
     */
    private LocalDate calculateRegistrationDate(LocalDate fromDate) {
        LocalDate date = fromDate;
        int workDays = 2;
        
        while (workDays > 0) {
            date = date.minusDays(1);
            if (holidayService.isWorkDay(date)) {  // 使用holidayService判断工作日
                workDays--;
            }
        }
        
        return date;
    }

}
