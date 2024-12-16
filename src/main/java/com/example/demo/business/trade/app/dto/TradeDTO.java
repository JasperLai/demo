package com.example.demo.business.trade.app.dto;

import java.math.BigDecimal;
import org.springframework.lang.NonNull;

public class TradeDTO {

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
     * 交易全价
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

    /**
     * 交易方ID
     */
    @NonNull
    private String partyId;

    /**
     * 支付方式（CARD-银行卡, PASSBOOK-存折）
     */
    @NonNull
    private String paymentMethod;

    /**
     * 开卡行
     */
    private String bankName;

    private String orderId;

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

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
} 