package com.example.demo.business.product.domain.domainObject;

import com.example.demo.business.product.domain.valueObject.BondBusinessAuth;

public class BondProduct {
    private String productCode;
    private String FDMCode;
    private Bond bond;
    private BondBusinessAuth authority;
    private BondQuotation quotation;
    private Inventory inventory;

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getFDMCode() {
        return this.FDMCode;
    }

    public void setFDMCode(String FDMCode) {
        this.FDMCode = FDMCode;
    }

    public Bond getBond() {
        return this.bond;
    }

    public void setBond(Bond bond) {
        this.bond = bond;
    }

    public BondBusinessAuth getAuthority() {
        return this.authority;
    }

    public void setAuthority(BondBusinessAuth authority) {
        this.authority = authority;
    }

    public BondQuotation getQuotation() {
        return this.quotation;
    }

    public void setQuotation(BondQuotation quotation) {
        this.quotation = quotation;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }


    /**
     * 获取产品生命周期，发行前，发行中，上市流通期
     * 根据 bond 的日期参数，和当前日期，判断生命周期
     * @return
     */
    public LifeCycle getLifeCycle(){
        return null;
    }

}
