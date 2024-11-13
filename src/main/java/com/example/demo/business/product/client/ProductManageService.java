package com.example.demo.business.product.client;

import com.example.demo.business.general.client.TransactionVO;
import com.example.demo.business.product.app.dto.request.BondRegistDTO;
import com.example.demo.business.product.app.dto.request.ProductQueryDTO;
import com.example.demo.business.product.app.dto.request.RecommendBondQueryDTO;
import com.example.demo.business.product.app.dto.request.TradeSwitchDTO;
import com.example.demo.business.product.app.dto.response.BondProductDTO;
import com.example.demo.common.exception.data.BaseData;
import com.example.demo.common.exception.data.ListData;

public interface ProductManageService {

    /* bond product regist */
    public boolean enterOriginBond(BondRegistDTO vo); 

    public BaseData registBondProduct(BondRegistDTO vo);

    public BaseData updateBondProduct(BondRegistDTO vo);


    /*switch manage */
    public BaseData setProductSwitch(TradeSwitchDTO vo, TransactionVO trans);
    
    public BaseData setTradeSwitch(TradeSwitchDTO vo, TransactionVO trans);

    public BaseData setRenewDefaultSwitch(String productID, TransactionVO trans);
    
    public ListData<TradeSwitchDTO> queryTradeSwitch(TradeSwitchDTO vo);
    
    public BaseData queryProductSwitch(String productID);

    /* PRODUCT QUERYING */
    public ListData<BondProductDTO> queryProductList(ProductQueryDTO vo);

    public BondProductDTO queryProductDetail(String productID);

    /* recommend setting */

    public void setRecommendBond(String productID, boolean isRecmd);

    public ListData<BondProductDTO> queryRecommendBondList(RecommendBondQueryDTO vo);


}
