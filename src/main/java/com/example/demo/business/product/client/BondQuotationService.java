package com.example.demo.business.product.client;

import com.example.demo.business.product.domain.entity.BondQuotation;
import com.example.demo.business.product.app.dto.response.QuotationLogDTO;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface BondQuotationService {
    /**
     * 报价查询
     * @param date 非必输默认当天
     * @param bondCode 非必输 
     */
    List<BondQuotation> queryQuotation(Date date, String bondCode);

    /**
     * 生成债券报价
     * @param productId 产品ID
     * @param baseYield 基准收益率
     */
    void generateQuotation(String productId, BigDecimal baseYield);

    /**
     * 报价点差设置
     * @param spread 点差值
     */
    void setYieldSpread(int spread);

    /**
     * 导出待报送当日报价文件
     * @param date 日期
     */
    void exportQuotationFile(Date date);

    /**
     * 接收报价中心推送的报价
     * @param quotationLogDTO 报价日志DTO
     * @return 流水号
     */
    String receiveQuotationPush(QuotationLogDTO quotationLogDTO);
} 