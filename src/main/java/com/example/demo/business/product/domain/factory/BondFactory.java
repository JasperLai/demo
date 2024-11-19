package com.example.demo.business.product.domain.factory;

import com.example.demo.business.product.app.dto.request.BondRegistDTO;
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
    
    public static Bond createFrom(BondRegistDTO dto) {
        Bond bond = new Bond(dto.getBondCode());
        
        // 基本字段转换
        bond.setShortName(dto.getBondShortName());
        bond.setVariety(convertToBondVariety(dto.getBondNature()));
        bond.setBondTerm(Integer.parseInt(dto.getBondTerm()));
        bond.setBondTermUnit(BondTermUnit.convertToTargetCode(dto.getBondTermUnit()));
        bond.setCoupon(dto.getCouponRate() != null ? new BigDecimal(dto.getCouponRate()) : null);
        bond.setCurrency(dto.getDenominatedCurrency());
        bond.setIssuePrice(new BigDecimal(dto.getBondIssuePrice()));
        
        // 日期字段转换
        bond.setMatureDate(parseDate(dto.getMaturityDate()));
        bond.setIssueEndDate(parseDate(dto.getDistributionEndDate()));
        bond.setListingDate(parseDate(dto.getListingDate()));
        bond.setAccrualDate(parseDate(dto.getInterestStartDate()));
        bond.setIssueDate(parseDate(dto.getIssueStartDate()));
        bond.setBusinessDate(parseDate(dto.getBusinessDate()));
        bond.setBondRegistrationDate(parseDate(dto.getBondRegistrationDate()));
        bond.setPrincipalValueEffectiveDate(parseDate(dto.getPrincipalValueEffectiveDate()));
        bond.setFirstInterestPaymentDate(parseDate(dto.getFirstInterestPaymentDate()));
        bond.setInterestPaymentDate(parseDate(dto.getInterestPaymentDate()));
        
        // 计息相关设置
        bond.setAccrualBase(AccrualBase.ACT365);  // 默认使用 ACT365
        bond.setAccrualMethod(convertToAccrualMethod(dto.getInterestCalculationMethod()));
        
        // 其他字段转换
        bond.setBondStatus(dto.getBondStatus());
        bond.setAddTimes(dto.getAddTimes() != null ? 
            Integer.parseInt(dto.getAddTimes()) : 0);
        bond.setBondPauseStatus(dto.getBondPauseStatus());
        bond.setInterestPaymentCycle(dto.getInterestPaymentCycle());
        
        return bond;
    }
    
    /**
     * 转换债券品种
     * TODO 需要添加债券品种的映射转换逻辑
     * 映射规则：
     * 1. BondRegistDTO.bondNature -> Bond.variety
     * 2. 需要确认：
     *    - 外部系统债券品种的编码规则
     *    - 与系统内部 BondVariety 枚举的对应关系
     *    - 是否需要处理特殊的债券品种
     *    - 对于未知债券品种的默认处理方式
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
            synchronized (DATE_FORMAT) {  // SimpleDateFormat 不是线程安全的，需要同步
                return DATE_FORMAT.parse(dateStr);
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("无效的日期格式: " + dateStr, e);
        }
    }
} 