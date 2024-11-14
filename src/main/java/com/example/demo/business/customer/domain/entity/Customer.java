package com.example.demo.business.customer.domain.entity;

import javax.validation.constraints.NotBlank;

public class Customer {
    @NotBlank(message = "客户号不能为空")
    private String custNum;        // 客户号
    
    @NotBlank(message = "客户类型不能为空")
    private String custType;       // 客户类型
    
    @NotBlank(message = "国籍不能为空")
    private String nat;            // 国籍
    
    @NotBlank(message = "交易账号不能为空")
    private String tradeAcc;       // 交易账号
    
    private String customerName;   // 客户姓名
    
    @NotBlank(message = "资金账号不能为空")
    private String captNum;        // 资金账号
    
    @NotBlank(message = "证件类型不能为空")
    private String docType;        // 证件类型
    
    @NotBlank(message = "证件号码不能为空")
    private String docNum;         // 证件号码

    // 构造函数
    public Customer() {}

    public String getCustNum() {
        return custNum;
    }

    public void setCustNum(String custNum) {
        this.custNum = custNum;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    public String getTradeAcc() {
        return tradeAcc;
    }

    public void setTradeAcc(String tradeAcc) {
        this.tradeAcc = tradeAcc;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCaptNum() {
        return captNum;
    }

    public void setCaptNum(String captNum) {
        this.captNum = captNum;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    // getter 和 setter 方法
    
    // ... 为每个字段生成 getter 和 setter
}
