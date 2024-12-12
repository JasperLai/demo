package com.example.demo.business.product.domain.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.example.demo.business.product.domain.entity.BondBusinessAuth.TransactionType;
import com.example.demo.business.product.domain.entity.Bond;
import com.example.demo.business.product.domain.entity.BondProduct;
import com.example.demo.business.product.domain.valueObject.BondLifeCycle;
import com.example.demo.business.product.app.dto.response.QuotaDTO;

public class ProductValidateRule {
    
    /**
     * 校验交易面额
     */
    public static void validateFaceAmount(Long faceAmount) {
        // 1. 检查是否为null
       
    }
    
    /**
     * 校验交易价格
     */
    public static void validatePrice(BigDecimal tradePrice, QuotaDTO latestQuota) {
        if (tradePrice == null || latestQuota == null) {
            throw new IllegalArgumentException("交易价格或最新报价不能为空");
        }
        
        // 价格比较，考虑精度
        // BigDecimal difference = tradePrice.subtract(latestQuota.getPrice())
        //     .abs()
        //     .setScale(4, RoundingMode.HALF_UP);
            
        // if (difference.compareTo(new BigDecimal("0.0001")) > 0) {
        //     throw new IllegalArgumentException("交易价格与最新报价不一致");
        // }
    }
    
    /**
     * 校验产品生命周期
     */
    public static void validateLifeCycle(BondProduct product, String tradeType) {
        if (product == null) {
            throw new IllegalArgumentException("产品不存在");
        }
        
        BondLifeCycle lifeCycle = product.getLifeCycle();
        
        // 分销交易必须在发行期进行
        if ("003".equals(tradeType)) { // 003为分销交易代码
            if (lifeCycle != BondLifeCycle.ISSUEING_PERIOD) {
                throw new IllegalArgumentException("分销交易只能在债券发行期进行");
            }
        }
    }
    
    /**
     * 校验分销权限
     */
    public static void validateDistributionAuth(BondProduct product) {
        if (product == null || product.getAuthority() == null) {
            throw new IllegalArgumentException("产品或权限信息不存在");
        }
        
        if (!product.getAuthority().canExecute(TransactionType.BUY_SELL)) {
            throw new IllegalArgumentException("该产品没有分销权限");
        }
    }
    
    /**
     * 校验库存
     */
    public static void validateInventory(BigDecimal faceAmountInYuan, long availableQuotaInCent) {
        if (faceAmountInYuan == null) {
            throw new IllegalArgumentException("交易面额不能为空");
        }
        
        // 将元转换为分
        long requestAmountInCent = faceAmountInYuan
            .multiply(new BigDecimal("100"))
            .longValue();
        
        if (requestAmountInCent > availableQuotaInCent) {
            throw new IllegalArgumentException(
                String.format("超出可用额度，当前可用：%s元，请求：%s元", 
                    new BigDecimal(availableQuotaInCent).divide(new BigDecimal("100")), 
                    faceAmountInYuan)
            );
        }
    }
} 