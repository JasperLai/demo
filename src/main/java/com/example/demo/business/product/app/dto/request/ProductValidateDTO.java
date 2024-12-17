package com.example.demo.business.product.app.dto.request;

import java.math.BigDecimal;
import org.springframework.lang.NonNull;

import com.example.demo.business.general.client.TradeType;
import com.example.demo.business.product.domain.valueObject.BondLifeCycle;

public class ProductValidateDTO {
    
    /**
     * 产品ID
     */
    @NonNull
    private String productId;


    private BondLifeCycle lifeCycle = null;

    private TradeType  authScenary = null;
    
    private BigDecimal buyDirtyPrice = null;

    private BigDecimal sellDirtyPrice = null;

    private Long tradeAmount = null;

    private String  saleArea = null;

    
    public ProductValidateDTO(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BondLifeCycle getLifeCycle() {
        return lifeCycle;
    }

    public void setLifeCycle(BondLifeCycle lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    public TradeType getAuthScenary() {
        return authScenary;
    }

    public void setAuthScenary(TradeType authScenary) {
        this.authScenary = authScenary;
    }

    public BigDecimal getBuyDirtyPrice() {
        return buyDirtyPrice;
    }

    public void setBuyDirtyPrice(BigDecimal buyDirtyPrice) {
        this.buyDirtyPrice = buyDirtyPrice;
    }

    public BigDecimal getSellDirtyPrice() {
        return sellDirtyPrice;
    }

    public void setSellDirtyPrice(BigDecimal sellDirtyPrice) {
        this.sellDirtyPrice = sellDirtyPrice;
    }

    public Long getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(Long tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public String getSaleArea() {
        return saleArea;
    }

    public void setSaleArea(String saleArea) {
        this.saleArea = saleArea;
    }

    

} 