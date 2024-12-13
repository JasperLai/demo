package com.example.demo.business.product.domain.service;

import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class HolidayService {
    
    /**
     * 判断是否为工作日
     */
    public boolean isWorkDay(LocalDate date) {
        // 1. 判断是否为周末
        if (isWeekend(date)) {
            return false;
        }
        
        // 2. 判断是否为法定节假日
        return !isHoliday(date);
    }
    
    private boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
    
    private boolean isHoliday(LocalDate date) {
        // TODO: 实现法定节假日判断逻辑
        // 可以通过配置文件或数据库存储节假日信息
        return false;
    }
} 