package com.example.demo.business.product.repository.dto;

public class ChangeQuoteDto {
    private String bondCode;
    private String channelId;
    private int changeQuantity;

    public ChangeQuoteDto(String channelId, int amount, String bondCode) {
        this.channelId = channelId;
        this.changeQuantity = amount;
        this.bondCode = bondCode;
    }

    public String getChannelId() {
        return channelId;
    }

    public int getChangeQuantity() {
        return changeQuantity;
    }

     public String getBondCode() {
        return this.bondCode;
    }
}
