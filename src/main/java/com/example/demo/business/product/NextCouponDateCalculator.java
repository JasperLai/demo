package com.example.demo.business.product;

import java.time.LocalDate;

public class NextCouponDateCalculator {

    public static LocalDate calculateNextCouponDate(int couponFrequencyMonths, int bondDurationYears, LocalDate issueDate) {
        // 计算债券的到期日
        LocalDate maturityDate = issueDate.plusYears(bondDurationYears);
        
        // 获取当前日期
        LocalDate currentDate = LocalDate.now();
        
        // 从起息日开始，按付息频率增加日期，直到找到大于或等于当前日期的付息日
        LocalDate nextCouponDate = issueDate;
        while (nextCouponDate.isBefore(currentDate) && !nextCouponDate.isEqual(maturityDate)) {
            nextCouponDate = nextCouponDate.plusMonths(couponFrequencyMonths);
        }
        
        // 如果计算出的付息日超过了到期日，则返回到期日
        if (nextCouponDate.isAfter(maturityDate)) {
            return maturityDate;
        }
        
        return nextCouponDate;
    }

    public static void main(String[] args) {
        int couponFrequencyMonths = 6; // 付息频率为6个月
        int bondDurationYears = 10; // 债券期限为10年
        LocalDate issueDate = LocalDate.of(2018, 8, 6); // 起息日为2020年1月1日

        LocalDate nextCouponDate = calculateNextCouponDate(couponFrequencyMonths, bondDurationYears, issueDate);
        System.out.println("下一个付息日: " + nextCouponDate);
    }
}
