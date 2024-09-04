package com.example.demo.business.product.client;

import com.example.demo.business.general.client.TransactionVO;
import com.example.demo.business.product.app.dto.request.BondRegistVO;
import com.example.demo.business.product.app.dto.request.ProductQueryVO;
import com.example.demo.business.product.app.dto.request.RecommendBondQueryVO;
import com.example.demo.business.product.app.dto.request.TradeSwitchVO;
import com.example.demo.business.product.app.dto.response.BondProductDTO;
import com.example.demo.business.product.app.dto.response.TradeSwitchDTO;
import com.example.demo.common.exception.data.BaseData;
import com.example.demo.common.exception.data.ListData;

public interface ProductManageService {

    /* bond product regist */
    public BaseData enterOriginBond(BondRegistVO vo); 

    public BaseData registBondProduct(BondRegistVO vo);

    public BaseData updateBondProduct(BondRegistVO vo);


    /*switch manage */
    public BaseData setProductSwitch(TradeSwitchVO vo, TransactionVO trans);
    
    public BaseData setTradeSwitch(TradeSwitchVO vo, TransactionVO trans);

    public BaseData setRenewDefaultSwitch(String productID, TransactionVO trans);
    
    public ListData<TradeSwitchDTO> queryTradeSwitch(TradeSwitchVO vo);

    public BaseData queryProductSwitch(String productID);

    /* PRODUCT QUERYING */
    public ListData<BondProductDTO> queryProductList(ProductQueryVO vo);

    public BondProductDTO queryProductDetail(String productID);

    /* recommend setting */

    public void setRecommendBond(String productID, boolean isRecmd);

    public ListData<BondProductDTO> queryRecommendBondList(RecommendBondQueryVO vo);


}
