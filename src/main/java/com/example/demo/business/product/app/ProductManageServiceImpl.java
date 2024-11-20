package com.example.demo.business.product.app;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.business.general.client.TMSInterface;
import com.example.demo.business.general.client.TradeType;
import com.example.demo.business.general.client.TransStatus;
import com.example.demo.business.general.client.TransactionVO;
import com.example.demo.business.product.adapter.request.BondRegistRequest;
import com.example.demo.business.product.app.dto.request.ProductQueryVO;
import com.example.demo.business.product.app.dto.request.RecommendBondQueryDTO;
import com.example.demo.business.product.app.dto.request.TradeSwitchDTO;
import com.example.demo.business.product.app.dto.response.BondDTO;
import com.example.demo.business.product.app.dto.response.BondProductDTO;
import com.example.demo.business.product.app.dto.response.QuotaDTO;
import com.example.demo.business.product.client.ProductManageService;
import com.example.demo.business.product.domain.entity.Bond;
import com.example.demo.business.product.domain.entity.BondProduct;
import com.example.demo.business.product.domain.repository.BondProductRepository;
import com.example.demo.common.exception.data.BaseData;
import com.example.demo.common.exception.data.ListData;

public class ProductManageServiceImpl implements ProductManageService {

    @Autowired
    private BondProductRepository bondProductRepository;

    @Autowired
    private TMSInterface transactionService;

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
    public BaseData registBondProduct(String bondCode, BondProductDTO productDTO, TransactionVO trans) {
        BaseData result = new BaseData();
        String transID = transactionService.createTransaction(trans, TradeType.PRODUCT_ENTER);

        registBondProduct(bondCode, productDTO);

        transactionService.updateTransaction(transID, TransStatus.SUCCESS);
        result.setSuccess(true);
        result.setReturnMsg("债券产品录入成功");
        return result;
    }

    @Override
    public void registBondProduct(String bondCode, BondProductDTO productDTO) {
        // 1. 检查债券是否存在
        BondDTO bondDTO = queryBondDetailWithCheck(bondCode);
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
    public BaseData updateBondProduct(BondProductDTO dto, TransactionVO trans) {
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
    public BaseData setProductSwitch(TradeSwitchDTO vo, TransactionVO trans) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setProductSwitch'");
    }

    @Override
    public BaseData setTradeSwitch(TradeSwitchDTO vo, TransactionVO trans) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTradeSwitch'");
    }

    @Override
    public BaseData setRenewDefaultSwitch(String productID, TransactionVO trans) {
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
    public QuotaDTO getCurrentQuotation(String productID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentQuotation'");
    }

    @Override
    public void isUnderDistribution(String productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isUnderDistribution'");
    }

    @Override
    public void checkInventory(BigDecimal faceAmount, String productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkInventory'");
    }

    @Override
    public void validateSaleArea(String productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateSaleArea'");
    }

    @Override
    public BaseData updateBondProduct(BondRegistRequest vo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBondProduct'");
    }

}
