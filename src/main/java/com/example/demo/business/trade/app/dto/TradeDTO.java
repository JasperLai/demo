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
    private Long quantity;

    /**
     * 交易全价
     */
    @NonNull
    private BigDecimal dirtyPrice;

    /**
     * 客户号
     */
    @NonNull
    private String BPNumber;

    /**
     * 资金账号
     */
    @NonNull
    private String PaymentAccountNumber;

    /**
     * 交易方ID
     */
    @NonNull
    private String partyId;

    /**
     * 支付方式（CARD-银行卡, PASSBOOK-存折）
     */
    @NonNull
    private String disburseMethod;

    /**
     * 开卡行
     */
    private String bankName;


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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getDirtyPrice() {
        return dirtyPrice;
    }

    public void setDirtyPrice(BigDecimal price) {
        this.dirtyPrice = price;
    }

    public String getBPNumber() {
        return BPNumber;
    }

    public void setBPNumber(String customerId) {
        this.BPNumber = customerId;
    }

    public String getPaymentAccountNumber() {
        return PaymentAccountNumber;
    }

    public void setPaymentAccountNumber(String cashAccountId) {
        this.PaymentAccountNumber = cashAccountId;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getDisburseMethod() {
        return disburseMethod;
    }

    public void setDisburseMethod(String paymentMethod) {
        this.disburseMethod = paymentMethod;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
} 