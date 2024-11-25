package com.example.demo.business.product.adapter.web;

import com.example.demo.business.product.app.dto.response.QuotationLogDTO;
import com.example.demo.business.product.client.QuotationManageService;
import com.example.demo.business.product.domain.entity.BondQuotation;
import com.example.demo.common.catchall.CatchAndLog;
import com.example.demo.common.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/quotation")
@CatchAndLog
public class QuotationController {

    @Autowired
    private QuotationManageService quotationManageService;

    /**
     * 查询报价信息
     * @param date 查询日期，非必填，默认当天
     * @param bondCode 债券代码，非必填
     * @return 报价信息列表
     */
    @GetMapping("/query")
    public Response<List<BondQuotation>> queryQuotation(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam(required = false) String bondCode) {
        return quotationManageService.queryQuotation(date, bondCode);
    }

    /**
     * 生成债券报价
     * @param productId 产品ID
     * @param baseYield 基准收益率
     * @return 处理结果
     */
    @PostMapping("/generate")
    public Response<Void> generateQuotation(
            @RequestParam String productId,
            @RequestParam BigDecimal baseYield) {
        return quotationManageService.generateQuotation(productId, baseYield);
    }

    /**
     * 设置报价点差
     * @param spread 点差值
     * @return 处理结果
     */
    @PostMapping("/spread")
    public Response<Void> setYieldSpread(@RequestParam int spread) {
        return quotationManageService.setYieldSpread(spread);
    }

    /**
     * 导出报价文件
     * @param date 导出日期
     * @return 处理结果
     */
    @GetMapping("/export")
    public Response<Void> exportQuotationFile(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return quotationManageService.exportQuotationFile(date);
    }

    /**
     * 接收报价推送
     * @param quotationLog 报价日志信息
     * @return 流水号
     */
    @PostMapping("/push")
    public Response<String> receiveQuotationPush(@RequestBody QuotationLogDTO quotationLog) {
        return quotationManageService.receiveQuotationPush(quotationLog);
    }
} 