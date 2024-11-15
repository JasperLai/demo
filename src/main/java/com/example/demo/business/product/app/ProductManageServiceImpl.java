package com.example.demo.business.product.app;

import java.math.BigDecimal;

import com.example.demo.business.general.client.TransactionVO;
import com.example.demo.business.product.app.dto.request.BondRegistDTO;
import com.example.demo.business.product.app.dto.request.ProductQueryDTO;
import com.example.demo.business.product.app.dto.request.RecommendBondQueryDTO;
import com.example.demo.business.product.app.dto.request.TradeSwitchDTO;
import com.example.demo.business.product.app.dto.response.BondProductDTO;
import com.example.demo.business.product.app.dto.response.QuotaDTO;
import com.example.demo.business.product.client.ProductManageService;
import com.example.demo.common.exception.data.BaseData;
import com.example.demo.common.exception.data.ListData;

public class ProductManageServiceImpl implements ProductManageService {

    // 录入原始债券数据全量
    @Override
    public boolean enterOriginBond(BondRegistDTO vo) {
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
    public BaseData registBondProduct(BondRegistDTO vo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'registBondProduct'");
    }

    @Override
    public BaseData updateBondProduct(BondRegistDTO vo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateBondProduct'");
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
    public ListData<BondProductDTO> queryProductList(ProductQueryDTO vo) {
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
    public ListData<BondProductDTO> queryRecommendBondList(RecommendBondQueryDTO vo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'queryRecommendBondList'");
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

}
