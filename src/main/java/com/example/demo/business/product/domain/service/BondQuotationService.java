package com.example.demo.business.product.domain.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.business.product.domain.entity.BondQuotation;
import com.example.demo.business.product.domain.repository.BondQuotationRepository;
@Component
public class BondQuotationService {
    private static final Logger logger = LogManager.getLogger(BondQuotationService.class);

    @Autowired
    private BondQuotationRepository repo;

    /**
     * TODO 报价查询，  
     * @param date 非必输默认当天
     * @param bondCode 非必输 
     * @return
     */
    public List<BondQuotation> queryQuotation(Date date, String bondCode){
        return null;
    }

    /**
     * TODO  wind报价基准查询，(日始解析 wind 数据落库查询)  
     * @param date 非必输默认当天
     * @param bondCode 
     * @return
     */
    private BigDecimal queryBaseQuotation(Date date, String bondCode){
        return null;
    }

    /**
     * TODO 报价点差设置，所有债券使用同一点差
     * @param spread
     */
    public void setYieldSpread(int spread){
        return;
    }

    /**
     *  TODO DCF 法计算债券现值
     * @param startIntDay 起息日
     * @param parValue 债券面值 非必输 默认 100
     * @param coupon 债券票息
     * @param discountRate 贴现收益率
     * @param intFremquency 付息频率 非必输 默认 12 每年付息一次
     * @return
     */
    public BigDecimal calculateQuotation(Date startIntDay, int parValue, BigDecimal coupon, int discountRate, int intFremquency){
        return null;
    }

    /**
     * TODO 导出待报送当日报价文件
     * @param spread
     */
    public void exportQuotationFile(Date date){
        return;
    }





}
