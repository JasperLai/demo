package com.example.demo.business.product.app.dto.response;

import com.example.demo.common.exception.data.BaseData;
import java.math.BigDecimal;
import java.util.Date;

public class QuotationLogDTO extends BaseData {
    private String transNo;
    private String traceNum;
    private String calcMode;
    private BigDecimal priceDecimal;
    private String priceSource;
    private String bondCode;
    private BigDecimal bondAccruInt;
    private BigDecimal compBuyNetPrice;
    private BigDecimal compSellNetPrice;
    private Date quotaTime;
    private Date expTime;
    private String tellerNum;
    private String productId;
    private BigDecimal compBuyFullPrice;
    private BigDecimal compSellFullPrice;
    private BigDecimal buyIncomeRate;
    private BigDecimal sellIncomeRate;
    private String bidSpread;
    private String askSpread;
    private BigDecimal evaluateRate;

    // Getters and Setters
    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }

    public String getTraceNum() {
        return traceNum;
    }

    public void setTraceNum(String traceNum) {
        this.traceNum = traceNum;
    }

    public String getCalcMode() {
        return calcMode;
    }

    public void setCalcMode(String calcMode) {
        this.calcMode = calcMode;
    }

    public BigDecimal getPriceDecimal() {
        return priceDecimal;
    }

    public void setPriceDecimal(BigDecimal priceDecimal) {
        this.priceDecimal = priceDecimal;
    }

    public String getPriceSource() {
        return priceSource;
    }

    public void setPriceSource(String priceSource) {
        this.priceSource = priceSource;
    }

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public BigDecimal getBondAccruInt() {
        return bondAccruInt;
    }

    public void setBondAccruInt(BigDecimal bondAccruInt) {
        this.bondAccruInt = bondAccruInt;
    }

    public BigDecimal getCompBuyNetPrice() {
        return compBuyNetPrice;
    }

    public void setCompBuyNetPrice(BigDecimal compBuyNetPrice) {
        this.compBuyNetPrice = compBuyNetPrice;
    }

    public BigDecimal getCompSellNetPrice() {
        return compSellNetPrice;
    }

    public void setCompSellNetPrice(BigDecimal compSellNetPrice) {
        this.compSellNetPrice = compSellNetPrice;
    }

    public Date getQuotaTime() {
        return quotaTime;
    }

    public void setQuotaTime(Date quotaTime) {
        this.quotaTime = quotaTime;
    }

    public Date getExpTime() {
        return expTime;
    }

    public void setExpTime(Date expTime) {
        this.expTime = expTime;
    }

    public String getTellerNum() {
        return tellerNum;
    }

    public void setTellerNum(String tellerNum) {
        this.tellerNum = tellerNum;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getCompBuyFullPrice() {
        return compBuyFullPrice;
    }

    public void setCompBuyFullPrice(BigDecimal compBuyFullPrice) {
        this.compBuyFullPrice = compBuyFullPrice;
    }

    public BigDecimal getCompSellFullPrice() {
        return compSellFullPrice;
    }

    public void setCompSellFullPrice(BigDecimal compSellFullPrice) {
        this.compSellFullPrice = compSellFullPrice;
    }

    public BigDecimal getBuyIncomeRate() {
        return buyIncomeRate;
    }

    public void setBuyIncomeRate(BigDecimal buyIncomeRate) {
        this.buyIncomeRate = buyIncomeRate;
    }

    public BigDecimal getSellIncomeRate() {
        return sellIncomeRate;
    }

    public void setSellIncomeRate(BigDecimal sellIncomeRate) {
        this.sellIncomeRate = sellIncomeRate;
    }

    public String getBidSpread() {
        return bidSpread;
    }

    public void setBidSpread(String bidSpread) {
        this.bidSpread = bidSpread;
    }

    public String getAskSpread() {
        return askSpread;
    }

    public void setAskSpread(String askSpread) {
        this.askSpread = askSpread;
    }

    public BigDecimal getEvaluateRate() {
        return evaluateRate;
    }

    public void setEvaluateRate(BigDecimal evaluateRate) {
        this.evaluateRate = evaluateRate;
    }
} 