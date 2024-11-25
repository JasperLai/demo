package com.example.demo.business.product.client;

import com.example.demo.business.product.domain.entity.BondQuotation;
import com.example.demo.business.product.app.dto.response.QuotationLogDTO;
import com.example.demo.common.response.Response;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface QuotationManageService {
    /**
     * 报价查询
     * @param date 非必输默认当天
     * @param bondCode 非必输 
     */
    Response<List<BondQuotation>> queryQuotation(Date date, String bondCode);

    /**
     * 生成债券报价
     * @param productId 产品ID
     * @param baseYield 基准收益率
     */
    Response<Void> generateQuotation(String productId, BigDecimal baseYield);

    /**
     * 报价点差设置
     * @param spread 点差值
     */
    Response<Void> setYieldSpread(int spread);

    /**
     * 导出待报送当日报价文件
     * @param date 日期
     */
    Response<Void> exportQuotationFile(Date date);

    /**
     * 接收报价中心推送的报价
     * @param quotationLogDTO 报价日志DTO
     * @return 流水号
     */
    Response<String> receiveQuotationPush(QuotationLogDTO quotationLogDTO);
} 