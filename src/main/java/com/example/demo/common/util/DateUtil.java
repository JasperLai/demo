package com.example.demo.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    // 获取 yyyyMMdd 格式的当前日期字符串
    public static String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        return currentDate.format(formatter);
    }

    // 获取 yyyy-MM-dd'T'HH:mm:ss.SSS 格式的当前日期时间字符串
    public static String getCurrentDateTime() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        return currentDateTime.format(formatter);
    }

    // 测试方法
    public static void main(String[] args) {
        System.out.println("当前日期字符串: " + getCurrentDate());
        System.out.println("当前日期时间字符串: " + getCurrentDateTime());
    }
}

