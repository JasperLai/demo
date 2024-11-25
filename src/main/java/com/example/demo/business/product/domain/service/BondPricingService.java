package com.example.demo.business.product.domain.service;

import com.example.demo.business.product.domain.entity.Bond;
import com.example.demo.business.product.domain.entity.BondProduct;
import com.example.demo.business.product.domain.entity.BondQuotation;
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
    public BondQuotation calculateQuotation(Bond bond, BondProduct product, BigDecimal baseYield) {
        // 1. 计算买入收益率和卖出收益率
        BigDecimal buyYield = calculateBuyYield(baseYield, product.getBidSpread());
        BigDecimal sellYield = calculateSellYield(baseYield, product.getAskSpread());
        
        // 2. 计算净价
        BigDecimal buyNetPrice = calculateNetPriceByDCF(bond, buyYield);
        BigDecimal sellNetPrice = calculateNetPriceByDCF(bond, sellYield);
        
        // 3. 计算应计利息
        BigDecimal accruedInterest = calculateAccruedInterest(bond);
        
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
                .map(cf -> calculatePresentValue(cf, yield, valueDate))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
                
        return presentValue.setScale(PRICE_SCALE, RoundingMode.HALF_UP);
    }
    
    /**
     * 计算应计利息
     */
    private BigDecimal calculateAccruedInterest(Bond bond) {
        // 根据债券的计息规则计算应计利息
        // TODO: 实现具体的应计利息计算逻辑
        return BigDecimal.ZERO;
    }
    
    /**
     * 生成现金流
     */
    private List<CashFlow> generateCashFlows(Bond bond) {
        // TODO: 根据债券的付息频率、付息日期等生成现金流
        return new ArrayList<>();
    }
    
    /**
     * 计算单现金流的现值
     */
    private BigDecimal calculatePresentValue(CashFlow cashFlow, BigDecimal yield, LocalDate valueDate) {
        // 计算时间因子
        double timeFactor = calculateTimeFactor(valueDate, cashFlow.getPaymentDate());
        
        // 计算折现因子
        BigDecimal discountFactor = BigDecimal.ONE.add(yield).pow((int)timeFactor);
        
        // 返回现值
        return cashFlow.getAmount().divide(discountFactor, PRICE_SCALE, RoundingMode.HALF_UP);
    }
    
    /**
     * 计算时间因子
     */
    private double calculateTimeFactor(LocalDate fromDate, LocalDate toDate) {
        // TODO: 根据债券的计息基础(如ACT/365、30/360等)计算时间因子
        return ChronoUnit.DAYS.between(fromDate, toDate) / 365.0;
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