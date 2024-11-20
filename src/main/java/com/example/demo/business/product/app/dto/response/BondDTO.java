package com.example.demo.business.product.app.dto.response;

import com.example.demo.business.product.domain.entity.Bond;
import com.example.demo.business.product.domain.valueObject.AccrualBase;
import com.example.demo.business.product.domain.valueObject.AccrualMethod;
import com.example.demo.business.product.domain.valueObject.BondVariety;
import com.example.demo.business.product.domain.valueObject.CustodyOrg;
import com.example.demo.common.exception.data.BaseData;
import java.math.BigDecimal;
import java.util.Date;

public class BondDTO extends BaseData {
    private String bondCode; // 债券代码
    private String shortName; // 债券简称
    private String bondVariety; // 债券品种
    private Integer bondTerm; // 债券期限
    private BigDecimal coupon; // 票面利率
    private String currency; // 币种
    private BigDecimal issuePrice; // 发行价格
    private Integer transferPauseDayBeforeCash; // 付息兑付日转托管业务停止天数
    private Date matureDate; // 到期日
    private Date issueEndDate; // 发行结束日
    private Date listingDate; // 上市流通日
    private Date accrualDate; // 起息日
    private Date issueDate; // 发行日
    private Integer accrualBase; // 计息基础
    private String accrualMethod; // 计息方式
    private Integer parValue; // 面值
    private String custodyOrg; // 托管机构
    private Date businessDate; // 业务日期
    private String bondStatus; // 债券状态
    private Integer addTimes; // 追加次数
    private String bondPauseStatus; // 债券暂停状态
    private Date bondRegistrationDate; // 债权登记日
    private BigDecimal currentPrincipalValue; // 当前本金值
    private Date principalValueEffectiveDate;// 本金值生效日
    private Date firstInterestPaymentDate; // 第一次付息日
    private String interestPaymentCycle; // 付息周期
    private Date interestPaymentDate; // 本计息期付息日
    private String bondTermUnit; // 债券期限单位
    private Date distStartDate; // 分销开始日
    private Date cutoffTransferDate; // 截止过户日

    public Bond toEntity() {
        Bond bond = new Bond();
        bond.setBondCode(this.bondCode);
        bond.setShortName(this.shortName);
        bond.setVariety(BondVariety.fromCode(this.bondVariety));
        bond.setBondTerm(this.bondTerm);
        bond.setCoupon(this.coupon);
        bond.setCurrency(this.currency);
        bond.setIssuePrice(this.issuePrice);
        bond.setTransferPauseDayBeforeCash(this.transferPauseDayBeforeCash);
        bond.setMatureDate(this.matureDate);
        bond.setIssueEndDate(this.issueEndDate);
        bond.setListingDate(this.listingDate);
        bond.setAccrualDate(this.accrualDate);
        bond.setIssueDate(this.issueDate);
        bond.setAccrualBase(AccrualBase.fromCode(this.accrualBase));
        bond.setAccrualMethod(AccrualMethod.fromCode(this.accrualMethod));
        bond.setParValue(this.parValue);
        bond.setCurrentPrincipalValue(this.currentPrincipalValue);
        bond.setCustodyOrg(CustodyOrg.fromCode(this.custodyOrg));
        bond.setBusinessDate(this.businessDate);
        bond.setBondStatus(this.bondStatus);
        bond.setAddTimes(this.addTimes);
        bond.setBondPauseStatus(this.bondPauseStatus);
        bond.setBondRegistrationDate(this.bondRegistrationDate);
        bond.setPrincipalValueEffectiveDate(this.principalValueEffectiveDate);
        bond.setFirstInterestPaymentDate(this.firstInterestPaymentDate);
        bond.setInterestPaymentCycle(this.interestPaymentCycle);
        bond.setInterestPaymentDate(this.interestPaymentDate);
        bond.setBondTermUnit(this.bondTermUnit);
        bond.setDistStartDate(this.distStartDate);
        bond.setCutoffTransferDate(this.cutoffTransferDate);
        return bond;
    }

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getBondVariety() {
        return bondVariety;
    }

    public void setBondVariety(String bondVariety) {
        this.bondVariety = bondVariety;
    }

    public Integer getBondTerm() {
        return bondTerm;
    }

    public void setBondTerm(Integer bondTerm) {
        this.bondTerm = bondTerm;
    }

    public BigDecimal getCoupon() {
        return coupon;
    }

    public void setCoupon(BigDecimal coupon) {
        this.coupon = coupon;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getIssuePrice() {
        return issuePrice;
    }

    public void setIssuePrice(BigDecimal issuePrice) {
        this.issuePrice = issuePrice;
    }

    public Integer getTransferPauseDayBeforeCash() {
        return transferPauseDayBeforeCash;
    }

    public void setTransferPauseDayBeforeCash(Integer transferPauseDayBeforeCash) {
        this.transferPauseDayBeforeCash = transferPauseDayBeforeCash;
    }

    public Date getMatureDate() {
        return matureDate;
    }

    public void setMatureDate(Date matureDate) {
        this.matureDate = matureDate;
    }

    public Date getIssueEndDate() {
        return issueEndDate;
    }

    public void setIssueEndDate(Date issueEndDate) {
        this.issueEndDate = issueEndDate;
    }

    public Date getListingDate() {
        return listingDate;
    }

    public void setListingDate(Date listingDate) {
        this.listingDate = listingDate;
    }

    public Date getAccrualDate() {
        return accrualDate;
    }

    public void setAccrualDate(Date accrualDate) {
        this.accrualDate = accrualDate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Integer getAccrualBase() {
        return accrualBase;
    }

    public void setAccrualBase(Integer accrualBase) {
        this.accrualBase = accrualBase;
    }

    public String getAccrualMethod() {
        return accrualMethod;
    }

    public void setAccrualMethod(String accrualMethod) {
        this.accrualMethod = accrualMethod;
    }

    public Integer getParValue() {
        return parValue;
    }

    public void setParValue(Integer parValue) {
        this.parValue = parValue;
    }

    public String getCustodyOrg() {
        return custodyOrg;
    }

    public void setCustodyOrg(String custodyOrg) {
        this.custodyOrg = custodyOrg;
    }

    public Date getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(Date businessDate) {
        this.businessDate = businessDate;
    }

    public String getBondStatus() {
        return bondStatus;
    }

    public void setBondStatus(String bondStatus) {
        this.bondStatus = bondStatus;
    }

    public Integer getAddTimes() {
        return addTimes;
    }

    public void setAddTimes(Integer addTimes) {
        this.addTimes = addTimes;
    }

    public String getBondPauseStatus() {
        return bondPauseStatus;
    }

    public void setBondPauseStatus(String bondPauseStatus) {
        this.bondPauseStatus = bondPauseStatus;
    }

    public Date getBondRegistrationDate() {
        return bondRegistrationDate;
    }

    public void setBondRegistrationDate(Date bondRegistrationDate) {
        this.bondRegistrationDate = bondRegistrationDate;
    }

    public Date getPrincipalValueEffectiveDate() {
        return principalValueEffectiveDate;
    }

    public void setPrincipalValueEffectiveDate(Date principalValueEffectiveDate) {
        this.principalValueEffectiveDate = principalValueEffectiveDate;
    }

    public Date getFirstInterestPaymentDate() {
        return firstInterestPaymentDate;
    }

    public void setFirstInterestPaymentDate(Date firstInterestPaymentDate) {
        this.firstInterestPaymentDate = firstInterestPaymentDate;
    }

    public String getInterestPaymentCycle() {
        return interestPaymentCycle;
    }

    public void setInterestPaymentCycle(String interestPaymentCycle) {
        this.interestPaymentCycle = interestPaymentCycle;
    }

    public Date getInterestPaymentDate() {
        return interestPaymentDate;
    }

    public void setInterestPaymentDate(Date interestPaymentDate) {
        this.interestPaymentDate = interestPaymentDate;
    }

    public String getBondTermUnit() {
        return bondTermUnit;
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
        return cutoffTransferDate;
    }

    public void setCutoffTransferDate(Date cutoffTransferDate) {
        this.cutoffTransferDate = cutoffTransferDate;
    }

    public static BondDTO fromEntity(Bond bond) {
        if (bond == null) {
            return null;
        }

        BondDTO dto = new BondDTO();
        dto.setBondCode(bond.getBondCode());
        dto.setShortName(bond.getShortName());
        if (bond.getVariety() != null) {
            dto.setBondVariety(bond.getVariety().getCode());
        }
        dto.setBondTerm(bond.getBondTerm());
        dto.setCoupon(bond.getCoupon());
        dto.setCurrency(bond.getCurrency());
        dto.setIssuePrice(bond.getIssuePrice());
        dto.setTransferPauseDayBeforeCash(bond.getTransferPauseDayBeforeCash());
        dto.setMatureDate(bond.getMatureDate());
        dto.setIssueEndDate(bond.getIssueEndDate());
        dto.setListingDate(bond.getListingDate());
        dto.setAccrualDate(bond.getAccrualDate());
        dto.setIssueDate(bond.getIssueDate());
        if (bond.getAccrualBase() != null) {
            dto.setAccrualBase(bond.getAccrualBase().getCode());
        }
        if (bond.getAccrualMethod() != null) {
            dto.setAccrualMethod(bond.getAccrualMethod().getCode());
        }
        dto.setParValue(bond.getParValue());
        dto.setCustodyOrg(bond.getCustodyOrg() != null ? bond.getCustodyOrg().getDisplayName() : null);
        dto.setBusinessDate(bond.getBusinessDate());
        dto.setBondStatus(bond.getBondStatus());
        dto.setAddTimes(bond.getAddTimes());
        dto.setBondPauseStatus(bond.getBondPauseStatus());
        dto.setBondRegistrationDate(bond.getBondRegistrationDate());
        dto.setPrincipalValueEffectiveDate(bond.getPrincipalValueEffectiveDate());
        dto.setFirstInterestPaymentDate(bond.getFirstInterestPaymentDate());
        dto.setInterestPaymentCycle(bond.getInterestPaymentCycle());
        dto.setInterestPaymentDate(bond.getInterestPaymentDate());
        dto.setBondTermUnit(bond.getBondTermUnit());
        dto.setDistStartDate(bond.getDistStartDate());
        dto.setCutoffTransferDate(bond.getCutoffTransferDate());
        return dto;
    }

    public BigDecimal getCurrentPrincipalValue() {
        return currentPrincipalValue;
    }

    public void setCurrentPrincipalValue(BigDecimal currentPrincipalValue) {
        this.currentPrincipalValue = currentPrincipalValue;
    }
}