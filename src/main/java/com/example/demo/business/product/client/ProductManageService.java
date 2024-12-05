package com.example.demo.business.product.client;

import java.math.BigDecimal;

import com.example.demo.business.general.app.dto.TransactionDTO;
import com.example.demo.business.product.adapter.request.BondRegistRequest;
import com.example.demo.business.product.app.dto.request.ProductQueryVO;
import com.example.demo.business.product.app.dto.request.TradeSwitchDTO;
import com.example.demo.business.product.app.dto.response.BondProductDTO;
import com.example.demo.business.product.app.dto.response.QuotaDTO;
import com.example.demo.common.exception.data.BaseData;
import com.example.demo.common.exception.data.ListData;

public interface ProductManageService {

    /* bond product regist */
    public boolean enterOriginBond(BondRegistRequest vo);

    public BaseData registBondProduct(String bondCode, BondProductDTO productDTO, TransactionDTO trans);

    public void registBondProduct(String bondCode, BondProductDTO productDTO);

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

    public QuotaDTO getCurrentQuotation(String productID);

    public void isUnderDistribution(String productId);

    public void checkInventory(BigDecimal faceAmount, String productId);

    public void validateSaleArea(String productId);

}
