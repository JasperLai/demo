package com.example.demo.business.product.domain.entity;

import com.example.demo.business.product.domain.valueObject.CustodyOrg;

public class Trader {
    //是否银行
    private boolean isBank;
    //名称
    private String name;
    //一级托管账号
    private int trustAccountId;
    //交易商代码
    private String traderCode;
    //托管机构
    private CustodyOrg custodyOrg;

    public boolean isBank() {
        return this.isBank;
    }

    public boolean getIsBank() {
        return this.isBank;
    }

    public void setIsBank(boolean isBank) {
        this.isBank = isBank;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTrustAccountId() {
        return this.trustAccountId;
    }

    public void setTrustAccountId(int status) {
        this.trustAccountId = status;
    }

    public String getTraderCode() {
        return this.traderCode;
    }

    public void setTraderCode(String traderCode) {
        this.traderCode = traderCode;
    }

    public CustodyOrg getCustodyOrg() {
        return this.custodyOrg;
    }

    public void setCustodyOrg(CustodyOrg custodyOrg) {
        this.custodyOrg = custodyOrg;
    }
}
