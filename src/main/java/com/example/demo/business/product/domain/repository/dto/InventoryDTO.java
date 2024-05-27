package com.example.demo.business.product.domain.repository.dto;

import com.example.demo.exception.BaseData;

public class InventoryDTO extends BaseData {

    private String intOrgNum;
    private String bondCd;
    private Long bondLimit;
    private String saleStragety;
    private String trustProNum;

    // Getters and setters

    public String getIntOrgNum() {
        return intOrgNum;
    }

    public void setIntOrgNum(String intOrgNum) {
        this.intOrgNum = intOrgNum;
    }

    public String getBondCd() {
        return bondCd;
    }

    public void setBondCd(String bondCd) {
        this.bondCd = bondCd;
    }

    public Long getBondLimit() {
        return bondLimit;
    }

    public void setBondLimit(Long bondLimit) {
        this.bondLimit = bondLimit;
    }

    public String getSaleStragety() {
        return saleStragety;
    }

    public void setSaleStragety(String saleStragety) {
        this.saleStragety = saleStragety;
    }

    public String getTrustProNum() {
        return trustProNum;
    }

    public void setTrustProNum(String trustProNum) {
        this.trustProNum = trustProNum;
    }

}
