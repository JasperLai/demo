package com.example.demo.business.product.client;

import java.util.List;

import com.example.demo.business.general.app.dto.TransactionDTO;
import com.example.demo.business.product.adapter.request.BondRegistRequest;
import com.example.demo.business.product.app.dto.request.ProductQueryVO;
import com.example.demo.business.product.app.dto.request.TradeSwitchDTO;
import com.example.demo.business.product.app.dto.response.BondDTO;
import com.example.demo.business.product.app.dto.response.BondProductDTO;
import com.example.demo.common.exception.data.BaseData;
import com.example.demo.common.exception.data.ListData;
import com.example.demo.business.product.app.dto.request.ProductValidateDTO;

public interface ProductManageService {

    /* bond product regist */
    public boolean enterOriginBond(BondRegistRequest vo);

    public BaseData registBondProduct( BondProductDTO productDTO, TransactionDTO trans);

    public void registBondProduct( BondProductDTO productDTO);

    public BaseData updateBondProduct(BondProductDTO productDTO, TransactionDTO trans);

    public void updateBondProduct(BondProductDTO productDTO);

    /* switch manage */
    public BaseData setProductSwitch(TradeSwitchDTO vo, TransactionDTO trans);

    public BaseData setTradeSwitch(TradeSwitchDTO vo, TransactionDTO trans);

    public BaseData setRenewDefaultSwitch(String productID, TransactionDTO trans);

    public ListData<TradeSwitchDTO> queryTradeSwitch(TradeSwitchDTO vo);

    public BaseData queryProductSwitch(String productID);

    /* PRODUCT QUERYING */
    public ListData<BondProductDTO> queryProductList(ProductQueryVO vo);

    public BondProductDTO queryProductDetail(String productID);

    /* recommend setting */

    public void setRecommendBond(String productID, boolean isRecmd);

    public List<BondDTO> queryBondsInRegistrationDate();


    /**
     * 校验交易请求
     * @param validateDTO 校验请求数据
     */
    void validateOrder(ProductValidateDTO validateDTO);

}
