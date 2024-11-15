package com.example.demo.business.customer.client;

public class CustomerDTO {
    private String custNum;        // 客户号
    private String custType;       // 客户类型
    private String nat;            // 国籍
    private String tradeAcc;       // 交易账号
    private String customerName;   // 客户姓名
    private String captNum;        // 资金账号
    private String docType;        // 证件类型
    private String docNum;         // 证件号码

    // 构造函数
    public CustomerDTO() {}

    // getter 和 setter 方法
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
}
