package com.example.demo.business.product.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import com.example.demo.business.product.domain.valueObject.BondVariety;
import com.example.demo.business.product.domain.valueObject.CustodyOrg;
import com.example.demo.business.product.domain.valueObject.AccrualBase;
import com.example.demo.business.product.domain.valueObject.AccrualMethod;
import com.example.demo.business.product.domain.valueObject.BondLifeCycle;

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
    private Integer bondTerm;

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
    private Integer transferPauseDayBeforeCash;

    /**
     * 到期日
     * 对应 BondRegistDTO.maturityDate
     */
    private Date matureDate;

    /**
     * 分销结束日
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
    private Integer parValue;

    /**
     * 当前本金值
     * 对应 BondRegistDTO.currentPrincipalValue
     */
    private BigDecimal currPrincipalVal;

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
    private Integer addTimes;

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
     * 付息周期 单位为月
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

    private Integer bondRegisterStopDayCnt; //

    private Integer recordDayCnt; //截止过户间隔

    public Bond() {
    }

    
    public Integer getBondRegisterStopDayCnt() {
        return bondRegisterStopDayCnt;
    }


    public void setBondRegisterStopDayCnt(Integer bondRegisterStopDayCnt) {
        this.bondRegisterStopDayCnt = bondRegisterStopDayCnt;
    }


    public Integer getRecordDayCnt() {
        return recordDayCnt;
    }


    public void setRecordDayCnt(Integer recordDayCnt) {
        this.recordDayCnt = recordDayCnt;
    }


    public Bond(String bondCode) {
        this.bondCode = bondCode;
    }

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

    public Integer getBondTerm() {
        return this.bondTerm;
    }

    public void setBondTerm(Integer bondTerm) {
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

    public Integer getTransferPauseDayBeforeCash() {
        return this.transferPauseDayBeforeCash;
    }

    public void setTransferPauseDayBeforeCash(Integer transferPauseDayBeforeCash) {
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

    public Integer getParValue() {
        return this.parValue;
    }

    public void setParValue(Integer parValue) {
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

    public Integer getAddTimes() {
        return this.addTimes;
    }

    public void setAddTimes(Integer addTimes) {
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

  
    public Integer getBondTermByUnit() {
        return 0;
    }

    public BigDecimal getCurrPrincipalVal() {
        return currPrincipalVal;
    }

    public void setCurrPrincipalVal(BigDecimal currentPrincipalValue) {
        this.currPrincipalVal = currentPrincipalValue;
    }

     
    /**
     * 判断当天是否可以进行转托管交易
     */
    public boolean canTransferToday() {
        // 如果债券状态不正常或者处于暂停状态，不允许转托管
        if (!"00".equals(bondStatus) || "2".equals(bondPauseStatus)) {
            return false;
        }
        
        // 获取下一个付息日
        LocalDate nextCouponDate = getNextCouponDate();
        if (nextCouponDate == null) {
            return true;
        }
        
        // 获取当前日期
        LocalDate today = LocalDate.now();
        
        // 如果转托管停办天数未设置，默认可以转托管
        if (transferPauseDayBeforeCash == null) {
            return true;
        }
        
        // 计算当前日期到下一付息日的天数
        long daysUntilCoupon = ChronoUnit.DAYS.between(today, nextCouponDate);
        
        // 如果距离付息日的天数小于等于停办天数，则不允许转托管
        return daysUntilCoupon > transferPauseDayBeforeCash;
    }

    /**
     * 获取下一个付息日
     */
    public LocalDate getNextCouponDate() {
        // 检查付息方式，某些类型不需要计算下一付息日
        if (this.accrualMethod == null) {
            return null;
        }
        
        // 获取当前日期
        LocalDate today = LocalDate.now();
        
        // 检查第一次付息日
        if (firstInterestPaymentDate != null) {
            LocalDate firstPaymentDate = firstInterestPaymentDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            if (!today.isAfter(firstPaymentDate)) {
                return firstPaymentDate;
            }
        }
        
        // 检查本期付息日
        if (interestPaymentDate != null) {
            LocalDate currentPaymentDate = interestPaymentDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            if (!today.isAfter(currentPaymentDate)) {
                return currentPaymentDate;
            }
        }
        
        // 如果以上都不满足，根据付息方式计算
        switch (this.accrualMethod) {
            case DISCOUNTING:        // 贴现
            case ZEROCOUPON:     // 零息
            case FULLREPAYMENT: // 利随本清
                return this.matureDate == null ? null : 
                    this.matureDate.toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
                
            case FIXRATE:      // 固定利率
            case FLOATRATE:   // 浮动利率
                return calculateNextPaymentDate();          
            case OTHER:            // 无付息
            default:
                return null;
        }
    }

    private LocalDate calculateNextPaymentDate() {
        // 检查必要参数
        if (this.interestPaymentCycle == null || !this.interestPaymentCycle.matches("\\d+") || this.accrualDate == null) {
            return null;
        }
        
        // 获取当前日期和起息日
        LocalDate today = LocalDate.now();
        LocalDate startDate = this.accrualDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        
        // 获取付息周期（月）
        int cycleMonths = Integer.parseInt(this.interestPaymentCycle);
        
        // 计算从起息日开始到当前日期经过了多少个完整周期
        long monthsBetween = ChronoUnit.MONTHS.between(startDate, today);
        int completedCycles = (int) (monthsBetween / cycleMonths);
        
        // 计算下一个付息日
        LocalDate nextPaymentDate = startDate.plusMonths((completedCycles + 1) * cycleMonths);
        
        // 如果债券已到期或下一付息日超过到期日，则返回到期日
        if (this.matureDate != null) {
            LocalDate maturityDate = this.matureDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            
            if ("01".equals(this.bondStatus) || nextPaymentDate.isAfter(maturityDate)) {
                return maturityDate;
            }
        }
        
        return nextPaymentDate;
    }

    /**
     * 获取截止至当日，以 PAR_VALUE 计算的应计利息
     */
    public BigDecimal getAccruedInterestTillNow() {
        // 如果没有票面利率或面值，返回0
        if (coupon == null || parValue == null) {
            return BigDecimal.ZERO;
        }

        // 获取当前日期
        LocalDate today = LocalDate.now();
        
        // 获取起息日
        if (accrualDate == null) {
            return BigDecimal.ZERO;
        }
        LocalDate startDate = accrualDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
            
        // 如果当前日期在起息日之前，返回0
        if (today.isBefore(startDate)) {
            return BigDecimal.ZERO;
        }

        // 根据不同的计息方式计算应计利息
        switch (accrualMethod) {
            case DISCOUNTING:
            case ZEROCOUPON:
            case OTHER:
                return BigDecimal.ZERO;
                
            case FULLREPAYMENT:
            case FIXRATE:
            case FLOATRATE:
                return calculateAccruedInterest(today, startDate);
                
            default:
                return BigDecimal.ZERO;
        }
    }

    private BigDecimal calculateAccruedInterest(LocalDate today, LocalDate startDate) {
        // 获取上一个付息日
        LocalDate lastPaymentDate = getLastPaymentDate();
        
        // 如果没有上一个付息日，使用起息日作为计算起点
        LocalDate calculationStartDate = lastPaymentDate != null ? lastPaymentDate : startDate;
        
        // 获取计息天数 - 从上一付息日（或起息日）到今天的天数
        long actualDays = ChronoUnit.DAYS.between(calculationStartDate, today);
        
        // 获取计息基础的年天数
        int daysInYear;
        switch (accrualBase) {
            case ACT366:
                daysInYear = 366;
                break;
            case ACT360:
                daysInYear = 360;
                break;
            case ACT365:
                daysInYear = 365;
                break;
            case ACTACT:
                daysInYear = calculationStartDate.isLeapYear() ? 366 : 365;
                break;
            case T30360:
                actualDays = calculate30360Days(calculationStartDate, today);
                daysInYear = 360;
                break;
            default:
                daysInYear = 365;
        }
        
        // 计算利息：面值 * 票面利率 * (实际天数/年化天数)
        return new BigDecimal(parValue)
                .multiply(coupon)
                .multiply(BigDecimal.valueOf(actualDays))
                .divide(BigDecimal.valueOf(daysInYear * 100), 8, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 获取上一个付息日
     */
    private LocalDate getLastPaymentDate() {
        LocalDate today = LocalDate.now();
        
        // 如果有本期付息日且已经过去，则本期付息日就是上一付息日
        if (interestPaymentDate != null) {
            LocalDate currentPaymentDate = interestPaymentDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            if (today.isAfter(currentPaymentDate)) {
                return currentPaymentDate;
            }
        }
        
        // 如果有第一次付息日且已经过去，需要根据付息周期计算上一付息日
        if (firstInterestPaymentDate != null && interestPaymentCycle != null 
                && interestPaymentCycle.matches("\\d+")) {
            LocalDate firstPayment = firstInterestPaymentDate.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            
            if (today.isAfter(firstPayment)) {
                int cycleMonths = Integer.parseInt(interestPaymentCycle);
                long monthsSinceFirst = ChronoUnit.MONTHS.between(firstPayment, today);
                int completedCycles = (int) (monthsSinceFirst / cycleMonths);
                return firstPayment.plusMonths((long) completedCycles * cycleMonths);
            }
        }
        
        return null;
    }

    private long calculate30360Days(LocalDate startDate, LocalDate endDate) {
        int y1 = startDate.getYear();
        int m1 = startDate.getMonthValue();
        int d1 = Math.min(startDate.getDayOfMonth(), 30);
        
        int y2 = endDate.getYear();
        int m2 = endDate.getMonthValue();
        int d2 = Math.min(endDate.getDayOfMonth(), 30);
        
        // 30/360 计算公式：(Y2-Y1)*360 + (M2-M1)*30 + (D2-D1)
        return (y2 - y1) * 360L + (m2 - m1) * 30L + (d2 - d1);
    }

    public BondLifeCycle getLifeCycle() {
        LocalDate today = LocalDate.now();
        
        // 如果债券状态为"01"(到期兑付)，则返回结束状态
        if ("01".equals(bondStatus)) {
            return BondLifeCycle.BOND_END;
        }
        
        // 转换相关日期为 LocalDate
        LocalDate issueStartLocalDate = issueDate != null ? 
            issueDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
        LocalDate issueEndLocalDate = issueEndDate != null ? 
            issueEndDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
        LocalDate listingLocalDate = listingDate != null ? 
            listingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
        LocalDate matureLocalDate = matureDate != null ? 
            matureDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
        
        // 判断生命周期
        if (issueStartLocalDate != null && today.isBefore(issueStartLocalDate)) {
            return BondLifeCycle.ISSUE_BEFORE;
        } else if (issueStartLocalDate != null && issueEndLocalDate != null && 
                   !today.isBefore(issueStartLocalDate) && !today.isAfter(issueEndLocalDate)) {
            return BondLifeCycle.ISSUEING_PERIOD;
        } else if (listingLocalDate != null && matureLocalDate != null && 
                   !today.isBefore(listingLocalDate) && !today.isAfter(matureLocalDate)) {
            return BondLifeCycle.LISTING_PERIOD;
        } else if (matureLocalDate != null && today.isAfter(matureLocalDate)) {
            return BondLifeCycle.BOND_END;
        }
        
        // 如果无法判断，默认返回发行前状态
        return BondLifeCycle.ISSUE_BEFORE;
    }

}
