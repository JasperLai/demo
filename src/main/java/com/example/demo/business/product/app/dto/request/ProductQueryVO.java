package com.example.demo.business.product.app.dto.request;

public class ProductQueryVO {
    private String producdId;
    private String bondCode;
    private String bondName;
    private String bondVariety;
    private String recmdFlag;

    public String getProducdId() {
        return producdId;
    }

    public void setProducdId(String producdId) {
        this.producdId = producdId;
    }

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getBondName() {
        return bondName;
    }

    public void setBondName(String bondName) {
        this.bondName = bondName;
    }

    public String getBondVariety() {
        return bondVariety;
    }

    public void setBondVariety(String bondVariety) {
        this.bondVariety = bondVariety;
    }

    public String getRecmdFlag() {
        return recmdFlag;
    }

    public void setRecmdFlag(String recmdFlag) {
        this.recmdFlag = recmdFlag;
    }

}
