package com.example.demo.business.product.adapter.response.dto;

import com.example.demo.exception.BaseData;

public class InventoryDTO extends BaseData {

    private String bondCode;
    private long quota;
    private String orgID;

    public String getBondCode() {
        return this.bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public long getQuota() {
        return this.quota;
    }

    public void setQuota(long quota) {
        this.quota = quota;
    }

    public String getOrgID() {
        return this.orgID;
    }

    public void setOrgID(String orgID) {
        this.orgID = orgID;
    }

}
