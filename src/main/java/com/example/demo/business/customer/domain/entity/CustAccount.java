package com.example.demo.business.customer.domain.entity;

import java.time.LocalDate;

import com.example.demo.business.customer.domain.value.InvestorType;
import com.example.demo.business.customer.domain.value.InvestorTypeCode;
import com.example.demo.business.customer.domain.value.CustAcctNum;

public class CustAccount {
    private String tradeAcc;                // 交易账号
    private CustAcctNum custAcctNum;        // 托管账号（值对象）
    private InvestorTypeCode invstTypeCode; // 投资人类别
    private InvestorType invstType;         // 投资人类型
    private LocalDate custOpenAcctDt;       // 客户开户日期
    private LocalDate cancelAcctDt;         // 账户销户日期
    private String custOpenAcctChan;        // 客户开户渠道
    private String signId;                  // 签约编号
    private String acctStatus;              // 账户状态
    private String currencyUom;             // 币种
    private String identifyCode;            // 身份识别码
    private String openAccountOrgan;        // 开户机构
    private String otcInvstNum;             // 投资者编号
    public String getTradeAcc() {
        return tradeAcc;
    }
    public void setTradeAcc(String tradeAcc) {
        this.tradeAcc = tradeAcc;
    }
    public CustAcctNum getCustAcctNum() {
        return custAcctNum;
    }
    public void setCustAcctNum(CustAcctNum custAcctNum) {
        this.custAcctNum = custAcctNum;
    }
    public InvestorTypeCode getInvstTypeCode() {
        return invstTypeCode;
    }
    public void setInvstTypeCode(InvestorTypeCode invstTypeCode) {
        this.invstTypeCode = invstTypeCode;
    }
    public InvestorType getInvstType() {
        return invstType;
    }
    public void setInvstType(InvestorType invstType) {
        this.invstType = invstType;
    }
    public LocalDate getCustOpenAcctDt() {
        return custOpenAcctDt;
    }
    public void setCustOpenAcctDt(LocalDate custOpenAcctDt) {
        this.custOpenAcctDt = custOpenAcctDt;
    }
    public LocalDate getCancelAcctDt() {
        return cancelAcctDt;
    }
    public void setCancelAcctDt(LocalDate cancelAcctDt) {
        this.cancelAcctDt = cancelAcctDt;
    }
    public String getCustOpenAcctChan() {
        return custOpenAcctChan;
    }
    public void setCustOpenAcctChan(String custOpenAcctChan) {
        this.custOpenAcctChan = custOpenAcctChan;
    }
    public String getSignId() {
        return signId;
    }
    public void setSignId(String signId) {
        this.signId = signId;
    }
    public String getAcctStatus() {
        return acctStatus;
    }
    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }
    public String getCurrencyUom() {
        return currencyUom;
    }
    public void setCurrencyUom(String currencyUom) {
        this.currencyUom = currencyUom;
    }
    public String getIdentifyCode() {
        return identifyCode;
    }
    public void setIdentifyCode(String identifyCode) {
        this.identifyCode = identifyCode;
    }
    public String getOpenAccountOrgan() {
        return openAccountOrgan;
    }
    public void setOpenAccountOrgan(String openAccountOrgan) {
        this.openAccountOrgan = openAccountOrgan;
    }
    public String getOtcInvstNum() {
        return otcInvstNum;
    }
    public void setOtcInvstNum(String otcInvstNum) {
        this.otcInvstNum = otcInvstNum;
    }

    // 这里需要生成 getter 和 setter 方法
    
    // 建议使用 Lombok 的 @Data 注解来自动生成
}
