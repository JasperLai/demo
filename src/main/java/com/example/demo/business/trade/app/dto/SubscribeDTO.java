package com.example.demo.business.trade.app.dto;

import java.math.BigDecimal;
import org.springframework.lang.NonNull;

public class SubscribeDTO {

    /**
     * 产品ID（债券代码）
     */
    @NonNull
    private String productId;

    /**
     * 币种（CNY-人民币）
     */
    @NonNull
    private String currency;

    /**
     * 交易面额
     */
    @NonNull
    private BigDecimal faceAmount;

    /**
     * 交易价格
     */
    @NonNull
    private BigDecimal price;

    /**
     * 客户号
     */
    @NonNull
    private String customerId;

    /**
     * 资金账号
     */
    @NonNull
    private String cashAccountId;

    @NonNull
    private String partyID;

    public String getPartyID() {
        return this.partyID;
    }

    public void setPartyID(String partyID) {
        this.partyID = partyID;
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getFaceAmount() {
        return faceAmount;
    }

    public void setFaceAmount(BigDecimal faceAmount) {
        this.faceAmount = faceAmount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCashAccountId() {
        return cashAccountId;
    }

    public void setCashAccountId(String cashAccountId) {
        this.cashAccountId = cashAccountId;
    }

}
