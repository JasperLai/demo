package com.example.demo.business.product.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.example.demo.business.product.domain.valueObject.BondVariety;
import com.example.demo.business.product.domain.valueObject.CustodyOrg;
import com.example.demo.business.product.domain.valueObject.AccrualBase;
import com.example.demo.business.product.domain.valueObject.AccrualMethod;

public class Bond {

    /**
     * 债券代码
     * 对应 BondRegistDTO.bondCode
     */
    private String bondCode;

    /**
     * 债券简称
     * 对应 BondRegistDTO.bondShortName
     */
    private String shortName;

    /**
     * 债券品种
     * 对应 BondRegistDTO.bondNature
     */
    private BondVariety variety;

    /**
     * 债券期限（年）
     * 对应 BondRegistDTO.bondTerm 和 bondTermUnit
     * 注：需要根据bondTermUnit进行单位转换
     */
    private int bondTerm;

    /**
     * 票面利率（%）
     * 对应 BondRegistDTO.couponRate
     */
    private BigDecimal coupon;

    /**
     * 币种
     * 对应 BondRegistDTO.denominatedCurrency
     */
    private String currency;

    /**
     * 发行价格
     * 对应 BondRegistDTO.bondIssuePrice
     */
    private BigDecimal issuePrice;

    /**
     * 付息兑付日转托管业务停止天数（工作日）
     * 注：需要根据 BondRegistDTO.cutoffTransferDate 计算得出
     */
    private int transferPauseDayBeforeCash;

    /**
     * 到期日
     * 对应 BondRegistDTO.maturityDate
     */
    private Date matureDate;

    /**
     * 发行结束日
     * 对应 BondRegistDTO.distributionEndDate
     */
    private Date issueEndDate;

    /**
     * 上市流通日
     * 对应 BondRegistDTO.listingDate
     */
    private Date listingDate;

    /**
     * 起息日
     * 对应 BondRegistDTO.interestStartDate
     */
    private Date accrualDate;

    /**
     * 发行日
     * 对应 BondRegistDTO.issueStartDate
     */
    private Date issueDate;

    /**
     * 计息基础
     * 注：需要根据 BondRegistDTO.interestCalculationMethod 转换得出
     */
    private AccrualBase accrualBase;

    /**
     * 计息方式
     * 对应 BondRegistDTO.interestCalculationMethod
     * 10-贴现 20-利随本清 31-附息式固定利率 32-附息式浮动利率 40-零息 99-无
     */
    private AccrualMethod accrualMethod;

    /**
     * 面值
     * 对应 BondRegistDTO.currentPrincipalValue
     */
    private int parValue;

    /**
     * 托管机构
     * 注：BondRegistDTO中无对应字段
     */
    private CustodyOrg custodyOrg;

    /**
     * 业务日期
     * 对应 BondRegistDTO.businessDate
     */
    private Date businessDate;

    /**
     * 债券状态 00-正常 01-到期兑付
     * 对应 BondRegistDTO.bondStatus
     */
    private String bondStatus;

    /**
     * 追加次数
     * 对应 BondRegistDTO.addTimes
     */
    private int addTimes;

    /**
     * 债券暂停状态 1-正常 2-暂停
     * 对应 BondRegistDTO.bondPauseStatus
     */
    private String bondPauseStatus;

    /**
     * 债权登记日
     * 对应 BondRegistDTO.bondRegistrationDate
     */
    private Date bondRegistrationDate;

    /**
     * 本金值生效日
     * 对应 BondRegistDTO.principalValueEffectiveDate
     */
    private Date principalValueEffectiveDate;

    /**
     * 第一次付息日
     * 对应 BondRegistDTO.firstInterestPaymentDate
     */
    private Date firstInterestPaymentDate;

    /**
     * 付息周期
     * 对应 BondRegistDTO.interestPaymentCycle
     */
    private String interestPaymentCycle;

    /**
     * 本计息期付息日
     * 对应 BondRegistDTO.interestPaymentDate
     */
    private Date interestPaymentDate;

    /**
     * 债券期限单位 0-年 1-月 2-日
     * 对应 BondRegistDTO.bondTermUnit 的映射值
     */
    private String bondTermUnit;

    /**
     * 分销开始日
     * 对应 BondRegistDTO.distributionStartDate
     */
    private Date distStartDate;

    /**
     * 截止过户日
     * 对应 BondRegistDTO.cutoffTransferDate
     */
    private Date cutoffTransferDate;

    public String getBondCode() {
        return this.bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public BondVariety getVariety() {
        return this.variety;
    }

    public void setVariety(BondVariety variety) {
        this.variety = variety;
    }

    public int getBondTerm() {
        return this.bondTerm;
    }

    public void setBondTerm(int bondTerm) {
        this.bondTerm = bondTerm;
    }

    public BigDecimal getCoupon() {
        return this.coupon;
    }

    public void setCoupon(BigDecimal coupon) {
        this.coupon = coupon;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getIssuePrice() {
        return this.issuePrice;
    }

    public void setIssuePrice(BigDecimal issuePrice) {
        this.issuePrice = issuePrice;
    }

    public int getTransferPauseDayBeforeCash() {
        return this.transferPauseDayBeforeCash;
    }

    public void setTransferPauseDayBeforeCash(int transferPauseDayBeforeCash) {
        this.transferPauseDayBeforeCash = transferPauseDayBeforeCash;
    }

    public Date getMatureDate() {
        return this.matureDate;
    }

    public void setMatureDate(Date matureDate) {
        this.matureDate = matureDate;
    }

    public Date getIssueEndDate() {
        return this.issueEndDate;
    }

    public void setIssueEndDate(Date issueEndDate) {
        this.issueEndDate = issueEndDate;
    }

    public Date getListingDate() {
        return this.listingDate;
    }

    public void setListingDate(Date startTradeDate) {
        this.listingDate = startTradeDate;
    }

    public Date getAccrualDate() {
        return this.accrualDate;
    }

    public void setAccrualDate(Date startIntDate) {
        this.accrualDate = startIntDate;
    }

    public Date getIssueDate() {
        return this.issueDate;
    }

    public void setIssueDate(Date issueStartDate) {
        this.issueDate = issueStartDate;
    }

    public AccrualBase getAccrualBase() {
        return this.accrualBase;
    }

    public void setAccrualBase(AccrualBase interestBase) {
        this.accrualBase = interestBase;
    }

    public AccrualMethod getAccrualMethod() {
        return this.accrualMethod;
    }

    public void setAccrualMethod(AccrualMethod interestType) {
        this.accrualMethod = interestType;
    }

    public int getParValue() {
        return this.parValue;
    }

    public void setParValue(int parValue) {
        this.parValue = parValue;
    }

    public CustodyOrg getCustodyOrg() {
        return this.custodyOrg;
    }

    public void setCustodyOrg(CustodyOrg custodyOrg) {
        if (custodyOrg == null) {
            throw new IllegalArgumentException("CustodyOrg cannot be null");
        }
        this.custodyOrg = custodyOrg;
    }

    public Date getBusinessDate() {
        return this.businessDate;
    }

    public void setBusinessDate(Date businessDate) {
        this.businessDate = businessDate;
    }

    public String getBondStatus() {
        return this.bondStatus;
    }

    public void setBondStatus(String bondStatus) {
        this.bondStatus = bondStatus;
    }

    public int getAddTimes() {
        return this.addTimes;
    }

    public void setAddTimes(int addTimes) {
        this.addTimes = addTimes;
    }

    public String getBondPauseStatus() {
        return this.bondPauseStatus;
    }

    public void setBondPauseStatus(String bondPauseStatus) {
        this.bondPauseStatus = bondPauseStatus;
    }

    public Date getBondRegistrationDate() {
        return this.bondRegistrationDate;
    }

    public void setBondRegistrationDate(Date bondRegistrationDate) {
        this.bondRegistrationDate = bondRegistrationDate;
    }

    public Date getPrincipalValueEffectiveDate() {
        return this.principalValueEffectiveDate;
    }

    public void setPrincipalValueEffectiveDate(Date principalValueEffectiveDate) {
        this.principalValueEffectiveDate = principalValueEffectiveDate;
    }

    public Date getFirstInterestPaymentDate() {
        return this.firstInterestPaymentDate;
    }

    public void setFirstInterestPaymentDate(Date firstInterestPaymentDate) {
        this.firstInterestPaymentDate = firstInterestPaymentDate;
    }

    public String getInterestPaymentCycle() {
        return this.interestPaymentCycle;
    }

    public void setInterestPaymentCycle(String interestPaymentCycle) {
        this.interestPaymentCycle = interestPaymentCycle;
    }

    public Date getInterestPaymentDate() {
        return this.interestPaymentDate;
    }

    public void setInterestPaymentDate(Date interestPaymentDate) {
        this.interestPaymentDate = interestPaymentDate;
    }

    public String getBondTermUnit() {
        return this.bondTermUnit;
    }

    public void setBondTermUnit(String bondTermUnit) {
        this.bondTermUnit = bondTermUnit;
    }

    public Date getDistStartDate() {
        return this.distStartDate;
    }

    public void setDistStartDate(Date distStartDate) {
        this.distStartDate = distStartDate;
    }

    public Date getCutoffTransferDate() {
        return this.cutoffTransferDate;
    }

    public void setCutoffTransferDate(Date cutoffTransferDate) {
        this.cutoffTransferDate = cutoffTransferDate;
    }

    /**
     * TODO 获取下一付息日
     * @return
     */
    public Date getNextDayForPayingInterest(){
        return null;
    }

    /**
     * TODO 计算当前付息周期的应计利息（以面额为单位）
     * @return 2 位小叔
     */
    public BigDecimal calculateCurrentInt(){
        return null;
    }

    /**
     *  TODO 判断当天是否可以进行转托管交易
     */
     public boolean canTransferToday(){
        return false;
    }

    public int getBondTermByUnit(){

        return 0;
    }

}

   