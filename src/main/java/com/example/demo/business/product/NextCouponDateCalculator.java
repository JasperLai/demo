package com.example.demo.business.product;

import java.time.LocalDate;

/**
 * 债券下一付息日计算器
 * 根据债券的付息频率、期限和起息日计算下一个付息日
 */
public class NextCouponDateCalculator {

    /**
     * 计算下一个付息日
     * @param couponFrequencyMonths 付息频率（月）
     * @param bondDurationYears 债券期限（年）
     * @param issueDate 起息日
     * @return 下一个付息日
     * @throws IllegalArgumentException 当入参无效时抛出
     */
    public static LocalDate calculateNextCouponDate(int couponFrequencyMonths, int bondDurationYears, LocalDate issueDate) {
        // 参数验证
        if (couponFrequencyMonths <= 0 || bondDurationYears <= 0 || issueDate == null) {
            throw new IllegalArgumentException("Invalid parameters");
        }

        // 计算到期日
        LocalDate maturityDate = issueDate.plusYears(bondDurationYears);
        LocalDate currentDate = LocalDate.now();
        
        // 如果当前日期已过到期日，直接返回到期日
        if (currentDate.isAfter(maturityDate)) {
            return maturityDate;
        }
        
        // 计算从起息日到当前日期的月份差
        long monthsBetween = issueDate.until(currentDate).toTotalMonths();
        // 计算已经过去的完整付息周期数
        long periods = monthsBetween / couponFrequencyMonths;
        // 计算下一个付息日
        LocalDate nextCouponDate = issueDate.plusMonths((periods + 1) * couponFrequencyMonths);
        
        // 如果计算出的付息日超过到期日，则返回到期日
        return nextCouponDate.isAfter(maturityDate) ? maturityDate : nextCouponDate;
    }

    /**
     * 测试用例
     */
    public static void main(String[] args) {
        int couponFrequencyMonths = 6; // 半年付息
        int bondDurationYears = 10; // 10年期债券
        LocalDate issueDate = LocalDate.of(2018, 8, 6); // 起息日

        LocalDate nextCouponDate = calculateNextCouponDate(couponFrequencyMonths, bondDurationYears, issueDate);
        System.out.println("下一个付息日: " + nextCouponDate);
    }
}
