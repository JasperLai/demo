package com.example.demo.business.product;

import java.time.LocalDate;

public class NextCouponDateCalculator {

    public static LocalDate calculateNextCouponDate(int couponFrequencyMonths, int bondDurationYears, LocalDate issueDate) {
        // 参数验证
        if (couponFrequencyMonths <= 0 || bondDurationYears <= 0 || issueDate == null) {
            throw new IllegalArgumentException("Invalid parameters");
        }

        LocalDate maturityDate = issueDate.plusYears(bondDurationYears);
        LocalDate currentDate = LocalDate.now();
        
        // 如果当前日期在到期日之后，返回到期日
        if (currentDate.isAfter(maturityDate)) {
            return maturityDate;
        }
        
        // 计算从起息日到当前日期的月份差
        long monthsBetween = issueDate.until(currentDate).toTotalMonths();
        // 计算需要的付息周期数
        long periods = monthsBetween / couponFrequencyMonths;
        // 计算下一个付息日
        LocalDate nextCouponDate = issueDate.plusMonths((periods + 1) * couponFrequencyMonths);
        
        return nextCouponDate.isAfter(maturityDate) ? maturityDate : nextCouponDate;
    }

    public static void main(String[] args) {
        int couponFrequencyMonths = 6; // 付息频率为6个月
        int bondDurationYears = 10; // 债券期限为10年
        LocalDate issueDate = LocalDate.of(2018, 8, 6); // 起息日为2020年1月1日

        LocalDate nextCouponDate = calculateNextCouponDate(couponFrequencyMonths, bondDurationYears, issueDate);
        System.out.println("下一个付息日: " + nextCouponDate);
    }
}
