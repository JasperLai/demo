package com.example.demo.business.product.repository.dto;

public class ChangeQuotationDto {
    private String bondCode;
    private String channelId;
    private int amount;

    public ChangeQuotationDto(String channelId, int amount, String bondCode) {
        this.channelId = channelId;
        this.amount = amount;
        this.bondCode = bondCode;
    }

    public String getChannelId() {
        return channelId;
    }

    public int getAmount() {
        return amount;
    }

     public String getBondCode() {
        return this.bondCode;
    }
}
