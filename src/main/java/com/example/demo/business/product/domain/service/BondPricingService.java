package com.example.demo.business.product.domain.service;

import com.example.demo.business.product.domain.entity.Bond;
import com.example.demo.business.product.domain.entity.BondProduct;
import com.example.demo.business.product.domain.entity.BondQuotation;
import com.example.demo.business.product.domain.valueObject.AccrualBase;
import com.example.demo.business.product.domain.valueObject.AccrualMethod;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;

@Service
public class BondPricingService {
    
    private static final int PRICE_SCALE = 4; // 价格精度
    private static final int RATE_SCALE = 4;  // 利率精度
    
    /**
     * 使用DCF方法计算债券报价
     */
    public BondQuotation calculateQuotation(BondProduct product, BigDecimal baseYield) {
        // 1. 计算买入收益率和卖出收益率
        BigDecimal buyYield = calculateBuyYield(baseYield, product.getBidSpread());
        BigDecimal sellYield = calculateSellYield(baseYield, product.getAskSpread());
        
        // 2. 计算净价
        BigDecimal buyNetPrice = calculateNetPriceByDCF(product.getBond(), buyYield);
        BigDecimal sellNetPrice = calculateNetPriceByDCF(product.getBond(), sellYield);
        
        // 3. 计算应计利息
        BigDecimal accruedInterest = product.getBond().getAccruedInterestTillNow();
        
        // 4. 创建报价对象
        BondQuotation quotation = BondQuotation.builder()
                .withQuotaTransNo(generateQuotaTransNo())
                .withProductId(product.getProductId())
                .withPriceType("DCF")
                .withBondAccruInt(accruedInterest)
                .withCompBuyNetPrice(buyNetPrice)
                .withCompSellNetPrice(sellNetPrice)
                .withBuyIncomeRate(buyYield)
                .withSellIncomeRate(sellYield)
                .build();
                
        // 计算全价
        quotation.calculateBuyFullPrice();
        quotation.calculateSellFullPrice();
        
        return quotation;
    }
    
    private String generateQuotaTransNo() {
        // TODO: 实现流水号生成逻辑
        return "QT" + System.currentTimeMillis();
    }
    
    /**
     * 计算买入收益率
     */
    private BigDecimal calculateBuyYield(BigDecimal baseYield, String bidSpread) {
        return baseYield.subtract(new BigDecimal(bidSpread))
                .setScale(RATE_SCALE, RoundingMode.HALF_UP);
    }
    
    /**
     * 计算卖出收益率
     */
    private BigDecimal calculateSellYield(BigDecimal baseYield, String askSpread) {
        return baseYield.add(new BigDecimal(askSpread))
                .setScale(RATE_SCALE, RoundingMode.HALF_UP);
    }
    
    /**
     * 使用DCF方法计算净价
     * DCF = Σ(CFi/(1+r)^ti) 
     * 其中：CFi为第i期现金流，r为收益率，ti为距离当前时点的年化时间
     */
    private BigDecimal calculateNetPriceByDCF(Bond bond, BigDecimal yield) {
        LocalDate valueDate = LocalDate.now();
        LocalDate maturityDate = bond.getMatureDate().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        
        // 计算剩余期限
        long remainingDays = ChronoUnit.DAYS.between(valueDate, maturityDate);
        if (remainingDays <= 0) {
            return BigDecimal.ZERO;
        }
        
        // 获取现金流
        List<CashFlow> cashFlows = generateCashFlows(bond);
        
        // 计算现值之和
        BigDecimal presentValue = cashFlows.stream()
                .map(cf -> calculatePresentValue(cf, yield, valueDate, bond.getAccrualBase()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
                
        return presentValue.setScale(PRICE_SCALE, RoundingMode.HALF_UP);
    }
    
    /**
     * 生成现金流
     */
    private List<CashFlow> generateCashFlows(Bond bond) {
        List<CashFlow> cashFlows = new ArrayList<>();
        
        // 如果不是固定利率或浮动利率债券，返回空列表
        if (bond.getAccrualMethod() != AccrualMethod.FIXRATE && 
            bond.getAccrualMethod() != AccrualMethod.FLOATRATE) {
            return cashFlows;
        }
        
        // 获取当前日期
        LocalDate valueDate = LocalDate.now();
        
        // 获取到期日
        LocalDate maturityDate = bond.getMatureDate().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
                
        // 如果已经到期，返回空列表
        if (!valueDate.isBefore(maturityDate)) {
            return cashFlows;
        }
        
        // 获取下一个付息日
        LocalDate nextPaymentDate = bond.getNextCouponDate();
        if (nextPaymentDate == null) {
            return cashFlows;
        }
        
        // 获取付息周期（月）
        int paymentCycle = Integer.parseInt(bond.getInterestPaymentCycle());
        
        // 计算每期利息金额
        BigDecimal parValue = new BigDecimal(bond.getParValue());
        BigDecimal couponRate = bond.getCoupon().divide(new BigDecimal("100"), 8, RoundingMode.HALF_UP);
        BigDecimal periodInterest = parValue.multiply(couponRate)
                .multiply(new BigDecimal(paymentCycle))
                .divide(new BigDecimal("12"), 8, RoundingMode.HALF_UP);
        
        // 生成付息现金流
        LocalDate currentPaymentDate = nextPaymentDate;
        while (!currentPaymentDate.isAfter(maturityDate)) {
            // 添加利息现金流
            cashFlows.add(new CashFlow(currentPaymentDate, periodInterest));
            
            // 如果是最后一期，添加本金现金流
            if (currentPaymentDate.equals(maturityDate)) {
                cashFlows.add(new CashFlow(maturityDate, parValue));
            }
            
            // 计算下一个付息日
            currentPaymentDate = currentPaymentDate.plusMonths(paymentCycle);
        }
        
        // 如果最后一期不是正好在到期日，需要额外添加本金现金流
        if (!cashFlows.isEmpty() && 
            !cashFlows.get(cashFlows.size() - 1).getPaymentDate().equals(maturityDate)) {
            cashFlows.add(new CashFlow(maturityDate, parValue));
        }
        
        return cashFlows;
    }
    
    /**
     * 计算单现金流的现值
     */
    private BigDecimal calculatePresentValue(CashFlow cashFlow, BigDecimal yield, LocalDate valueDate, AccrualBase accrualBase) {
        // 计算时间因子
        double timeFactor = calculateTimeFactor(valueDate, cashFlow.getPaymentDate(), accrualBase);
        
        // 计算折现因子
        BigDecimal discountFactor = BigDecimal.ONE.add(yield).pow((int)timeFactor);
        
        // 返回现值
        return cashFlow.getAmount().divide(discountFactor, PRICE_SCALE, RoundingMode.HALF_UP);
    }
    
    /**
     * 计算时间因子
     * @param fromDate 起始日期
     * @param toDate 结束日期
     * @return 时间因子
     */
    private double calculateTimeFactor(LocalDate fromDate, LocalDate toDate, AccrualBase accrualBase) {
        if (fromDate.isAfter(toDate)) {
            return 0.0;
        }
        
        // 获取债券的计息基础
        if (accrualBase == null) {
            // 如果未指定计息基础，默认使用实际天数/365
            return ChronoUnit.DAYS.between(fromDate, toDate) / 365.0;
        }
        
        switch (accrualBase) {
            case ACT365:
                // 实际天数/365
                return ChronoUnit.DAYS.between(fromDate, toDate) / 365.0;
                
            case ACT360:
                // 实际天数/360
                return ChronoUnit.DAYS.between(fromDate, toDate) / 360.0;
                
            case ACT366:
                // 实际天数/366
                return ChronoUnit.DAYS.between(fromDate, toDate) / 366.0;
                
            case ACTACT:
                // 实际天数/实际年度天数
                long days = ChronoUnit.DAYS.between(fromDate, toDate);
                if (fromDate.getYear() == toDate.getYear()) {
                    // 如果在同一年，使用该年的实际天数
                    return days / (fromDate.isLeapYear() ? 366.0 : 365.0);
                } else {
                    // 如果跨年，需要分段计算
                    double factor = 0.0;
                    LocalDate currentDate = fromDate;
                    while (currentDate.isBefore(toDate)) {
                        LocalDate yearEnd = LocalDate.of(currentDate.getYear(), 12, 31);
                        if (yearEnd.isAfter(toDate)) {
                            yearEnd = toDate;
                        }
                        long yearDays = ChronoUnit.DAYS.between(currentDate, yearEnd);
                        factor += yearDays / (currentDate.isLeapYear() ? 366.0 : 365.0);
                        currentDate = yearEnd.plusDays(1);
                    }
                    return factor;
                }
                
            case T30360:
                // 30/360方法
                int y1 = fromDate.getYear();
                int m1 = fromDate.getMonthValue();
                int d1 = Math.min(fromDate.getDayOfMonth(), 30);
                
                int y2 = toDate.getYear();
                int m2 = toDate.getMonthValue();
                int d2 = Math.min(toDate.getDayOfMonth(), 30);
                
                // 如果是月末，特殊处理日期
                if (d1 == 30 && d2 == 30) {
                    d2 = 30;
                }
                
                // 30/360公式：(360*(Y2-Y1) + 30*(M2-M1) + (D2-D1))/360
                return (360 * (y2 - y1) + 30 * (m2 - m1) + (d2 - d1)) / 360.0;
                
            default:
                // 默认使用实际天数/365
                return ChronoUnit.DAYS.between(fromDate, toDate) / 365.0;
        }
    }
    
    /**
     * 现金流类
     */
    private static class CashFlow {
        private final LocalDate paymentDate;
        private final BigDecimal amount;
        
        public CashFlow(LocalDate paymentDate, BigDecimal amount) {
            this.paymentDate = paymentDate;
            this.amount = amount;
        }
        
        public LocalDate getPaymentDate() {
            return paymentDate;
        }
        
        public BigDecimal getAmount() {
            return amount;
        }
    }
} 