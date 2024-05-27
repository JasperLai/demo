package com.example.demo.business.product.adapter.request;

import com.example.demo.common.request.QueryBaseRequest;

public class QueryKeAcFacility extends QueryBaseRequest{

    private String product_Code;
    private String bond_Code;

    // Getters and setters
    public String getProduct_Code() {
        return product_Code;
    }

    public void setProduct_Code(String productCode) {
        this.product_Code = productCode;
    }

    public String getBond_Code() {
        return bond_Code;
    }

    public void setBond_Code(String bondCode) {
        this.bond_Code = bondCode;
    }
}
