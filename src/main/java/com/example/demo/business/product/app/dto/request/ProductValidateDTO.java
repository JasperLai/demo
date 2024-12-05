package com.example.demo.business.product.app.dto.request;

import java.math.BigDecimal;
import org.springframework.lang.NonNull;

public class ProductValidateDTO {
    
    /**
     * 产品ID
     */
    @NonNull
    private String productId;
    
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
     * 交易类型
     */
    @NonNull
    private String tradeType;

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }
} 