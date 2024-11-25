package com.example.demo.business.product.app;

import com.example.demo.business.product.domain.entity.Bond;
import com.example.demo.business.product.domain.entity.BondProduct;
import com.example.demo.business.product.domain.entity.BondQuotation;
import com.example.demo.business.product.domain.service.BondPricingService;
import com.example.demo.business.product.domain.repository.BondQuotationRepository;
import com.example.demo.business.product.domain.repository.BondProductRepository;
import com.example.demo.business.product.client.QuotationManageService;
import com.example.demo.business.product.app.dto.response.QuotationLogDTO;
import com.example.demo.business.product.infrastructure.repository.QuotationLogRepository;
import com.example.demo.common.response.Response;
import com.example.demo.common.catchall.CatchAndLog;
import com.example.demo.common.exception.BizException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

@Service
@CatchAndLog
public class QuotationManageServiceImpl implements QuotationManageService {
    private static final Logger logger = LogManager.getLogger(QuotationManageServiceImpl.class);

    @Autowired
    private BondPricingService bondPricingService;
    
    @Autowired
    private BondQuotationRepository bondQuotationRepository;
    
    @Autowired
    private BondProductRepository bondProductRepository;
    
    @Autowired
    private QuotationLogRepository quotationLogRepository;

    @Override
    @Transactional(readOnly = true)
    public Response<List<BondQuotation>> queryQuotation(Date date, String bondCode) {
        logger.info("查询报价信息, 日期: {}, 债券代码: {}", date, bondCode);
        
        if (date == null) {
            date = new Date();
        }
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date startDate = calendar.getTime();
        
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date endDate = calendar.getTime();

        List<BondQuotation> quotations;
        if (bondCode != null && !bondCode.isEmpty()) {
            quotations = bondQuotationRepository.findByBondCodeAndDate(bondCode, startDate, endDate);
        } else {
            quotations = bondQuotationRepository.findByDate(startDate, endDate);
        }
        
        logger.info("查询到{}条有效报价记录", quotations.size());
        return Response.success(quotations);
    }

    @Override
    @Transactional
    public Response<Void> generateQuotation(String productId, BigDecimal baseYield) {
        logger.info("开始生成产品{}的报价, 基准收益率: {}", productId, baseYield);
        
        BondProduct product = bondProductRepository.findByProductId(productId);
        if (product == null) {
            throw new BizException("PRODUCT_NOT_FOUND", "产品不存在: " + productId);
        }
        
        Bond bond = product.getBond();
        if (bond == null) {
            throw new BizException("BOND_NOT_FOUND", "产品未关联债券信息: " + productId);
        }
        
        BondQuotation quotation = bondPricingService.calculateQuotation(bond, product, baseYield);
        bondQuotationRepository.save(quotation);
        
        logger.info("产品{}报价生成完成", productId);
        return Response.success(null);
    }

    @Override
    @Transactional
    public Response<Void> setYieldSpread(int spread) {
        // TODO: 实现点差设置逻辑
        return Response.success(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Response<Void> exportQuotationFile(Date date) {
        // TODO: 实现报价文件导出逻辑
        return Response.success(null);
    }

    @Override
    @Transactional
    public Response<String> receiveQuotationPush(QuotationLogDTO quotationLogDTO) {
        logger.info("接收报价推送, 债券代码: {}, 报价来源: {}", quotationLogDTO.getBondCode(), quotationLogDTO.getPriceSource());
        
        if (quotationLogDTO == null || quotationLogDTO.getBondCode() == null || quotationLogDTO.getTransNo() == null) {
            throw new BizException("INVALID_PARAM", "报价推送参数不完整");
        }

        quotationLogRepository.save(quotationLogDTO);
        
        logger.info("报价推送记录成功, 流水号: {}", quotationLogDTO.getTransNo());
        return Response.success(quotationLogDTO.getTransNo());
    }
} 