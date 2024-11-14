package com.example.demo.business.product.domain.entity;

import com.example.demo.business.product.domain.valueObject.BondLifeCycle;
import com.example.demo.business.product.domain.valueObject.FDMProductCode;
import com.example.demo.business.product.domain.valueObject.ProductCode;

public class BondProduct {
    private ProductCode productCode;
    private FDMProductCode FDMCode;
    private Bond bond;
    private BondBusinessAuth authority;
    public long upperLimit = Long.MAX_VALUE;  //默认无上限
    public long lowerLimit = 0; //默认下限为 0
    

    private BondProduct() {
    }

    public static BondProduct builder() {
        return new BondProduct();
    }

    public BondProduct withProductCode(String bondCode) {
        this.productCode = ProductCode.create(bondCode);
        return this;
    }

    public BondProduct withFDMCode(String bondCode) {
        this.FDMCode = FDMProductCode.create(bondCode);
        return this;
    }

    public BondProduct withBond(Bond bond) {
        this.bond = bond;
        return this;
    }

    public BondProduct withAuthority(BondBusinessAuth authority) {
        this.authority = authority;
        return this;
    }

    // 在链式初始化完成后，可以调用 build 方法获取最终的对象
    public BondProduct build() {
        return this;
    }

    public String getProductCode() {
        return this.productCode.getCode();
    }


    public String getFDMCode() {
        return this.FDMCode.toString();
    }


    public Bond getBond() {
        return this.bond;
    }

    // public void setBond(Bond bond) {
    //     this.bond = bond;
    // }

    public BondBusinessAuth getAuthority() {
        return this.authority;
    }

    public void setAuthority(BondBusinessAuth authority) {
        this.authority = authority;
    }

    /**
     * 获取产品生命周期，发行前，发行中，上市流通期
     * TODO 根据 bond 的日期参数，和当前日期，判断生命周期
     * @return
     */
    public BondLifeCycle getLifeCycle(){
        return null;
    }

    /**
     *  TODO 根据产品编码判断是否续发行
     * @return
     */
    public boolean isReissue(){
        return true;
    }

}
