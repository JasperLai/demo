package com.example.demo.business.product.app.dto.request;

public class TransferVO {

    private String orgId;  // Target organization receiving the quota
    private long amount;   // Amount of quota to be transferred

    // Constructor, getters, and setters
    public TransferVO(String orgId, long amount) {
        this.orgId = orgId;
        this.amount = amount;
    }

    public String getOrgId() {
        return orgId;
    }

    public long getAmount() {
        return amount;
    }
}

