package com.example.demo.business.product.app;

import com.example.demo.business.general.client.TransactionVO;
import com.example.demo.business.product.app.dto.request.BondRegistDTO;
import com.example.demo.business.product.app.dto.request.ProductQueryDTO;
import com.example.demo.business.product.app.dto.request.RecommendBondQueryDTO;
import com.example.demo.business.product.app.dto.request.TradeSwitchDTO;
import com.example.demo.business.product.app.dto.response.BondProductDTO;
import com.example.demo.business.product.client.ProductManageService;
import com.example.demo.common.exception.data.BaseData;
import com.example.demo.common.exception.data.ListData;

public class ProductManageServiceImpl implements ProductManageService{

    // 录入原始债券数据全量
    @Override
    public BaseData enterOriginBond(BondRegistDTO vo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enterOriginBond'");
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

}
