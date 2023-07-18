package com.example.demo.vo;

import java.util.List;

public class BusinessPara {
    private int purchaseUnit;
    private String productCode;
    private String bankChargeRate;
    private double purchaseLimit;
    private double basicQuota;
    private List<QuotaAllocation> quotaAllocation;
    private ManualQuotaPara manualQuotaPara;
    

    public int getPurchaseUnit() {
        return this.purchaseUnit;
    }

    public void setPurchaseUnit(int purchaseUnit) {
        this.purchaseUnit = purchaseUnit;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBankChargeRate() {
        return this.bankChargeRate;
    }

    public void setBankChargeRate(String bankChargeRate) {
        this.bankChargeRate = bankChargeRate;
    }

    public double getPurchaseLimit() {
        return this.purchaseLimit;
    }

    public void setPurchaseLimit(double purchaseLimit) {
        this.purchaseLimit = purchaseLimit;
    }

    public double getBasicQuota() {
        return this.basicQuota;
    }

    public void setBasicQuota(double basicQuota) {
        this.basicQuota = basicQuota;
    }

    public List<QuotaAllocation> getQuotaAllocation() {
        return this.quotaAllocation;
    }

    public void setQuotaAllocation(List<QuotaAllocation> quotaAllocation) {
        this.quotaAllocation = quotaAllocation;
    }

    public ManualQuotaPara getManualQuotaPara() {
        return this.manualQuotaPara;
    }

    public void setManualQuotaPara(ManualQuotaPara manualQuotaPara) {
        this.manualQuotaPara = manualQuotaPara;
    }
   
}