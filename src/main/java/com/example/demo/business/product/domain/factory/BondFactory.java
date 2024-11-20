package com.example.demo.business.product.domain.factory;

import com.example.demo.business.product.adapter.request.BondRegistRequest;
import com.example.demo.business.product.domain.entity.Bond;
import com.example.demo.business.product.domain.valueObject.AccrualBase;
import com.example.demo.business.product.domain.valueObject.AccrualMethod;
import com.example.demo.business.product.domain.valueObject.BondTermUnit;
import com.example.demo.business.product.domain.valueObject.BondVariety;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BondFactory {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 转换债券品种
     * TODO 需要添加债券品种的映射转换逻辑
     * 映射规则：
     * 1. BondRegistDTO.bondNature -> Bond.variety
     * 2. 需要确认：
     * - 外部系统债券品种的编码规则
     * - 与系统内部 BondVariety 枚举的对应关系
     * - 是否需要处理特殊的债券品种
     * - 对于未知债券品种的默认处理方式
     * 
     * @param bondNature 外部系统的债券品种代码
     * @return 系统内部的债券品种枚举值
     */
    private static BondVariety convertToBondVariety(String bondNature) {
        if (bondNature == null || bondNature.trim().isEmpty()) {
            return null;
        }
        // TODO 需要添加债券品种的映射转换逻辑
        return null;
    }

    private static AccrualMethod convertToAccrualMethod(String method) {
        if (method == null || method.trim().isEmpty()) {
            return null;
        }

        switch (method) {
            case "10":
                return AccrualMethod.DISCOUNTING;
            case "20":
                return AccrualMethod.FULLREPAYMENT;
            case "31":
                return AccrualMethod.FIXRATE;
            case "32":
                return AccrualMethod.FLOATRATE;
            case "40":
                return AccrualMethod.ZEROCOUPON;
            case "99":
                return AccrualMethod.OTHER;
            default:
                throw new IllegalArgumentException("不支持的计息方式: " + method);
        }
    }

    private static Date parseDate(String dateStr) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            return null;
        }
        try {
            synchronized (DATE_FORMAT) { // SimpleDateFormat 不是线程安全的，需要同步
                return DATE_FORMAT.parse(dateStr);
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("无效的日期格式: " + dateStr, e);
        }
    }
}