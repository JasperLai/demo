package com.example.demo.business.product.app;

import com.example.demo.business.product.domain.entity.Bond;
import com.example.demo.business.product.domain.entity.BondProduct;
import com.example.demo.business.product.domain.entity.BondQuotation;
import com.example.demo.business.product.domain.service.BondPricingService;
import com.example.demo.business.product.domain.repository.BondQuotationRepository;
import com.example.demo.business.product.domain.repository.BondProductRepository;
import com.example.demo.business.product.client.BondQuotationService;
import com.example.demo.business.product.app.dto.response.QuotationLogDTO;
import com.example.demo.business.product.infrastructure.repository.QuotationLogRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class BondQuotationServiceImpl implements BondQuotationService {
    private static final Logger logger = LogManager.getLogger(BondQuotationServiceImpl.class);

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
    public List<BondQuotation> queryQuotation(Date date, String bondCode) {
        logger.info("查询报价信息, 日期: {}, 债券代码: {}", date, bondCode);
        // TODO: 实现报价查询逻辑
        return null;
    }

    @Override
    @Transactional
    public void generateQuotation(String productId, BigDecimal baseYield) {
        logger.info("开始生成产品{}的报价, 基准收益率: {}", productId, baseYield);
        
        BondProduct product = bondProductRepository.findByProductId(productId);
        if (product == null) {
            throw new IllegalArgumentException("产品不存在: " + productId);
        }
        
        Bond bond = product.getBond();
        if (bond == null) {
            throw new IllegalArgumentException("产品未关联债券信息: " + productId);
        }
        
        // 使用定价服务计算报价
        BondQuotation quotation = bondPricingService.calculateQuotation(bond, product, baseYield);
        
        // 保存报价
        bondQuotationRepository.save(quotation);
        
        logger.info("产品{}报价生成完成", productId);
    }

    @Override
    @Transactional
    public void setYieldSpread(int spread) {
        // TODO: 实现点差设置逻辑
    }

    @Override
    @Transactional(readOnly = true)
    public void exportQuotationFile(Date date) {
        // TODO: 实现报价文件导出逻辑
    }

    @Override
    @Transactional
    public String receiveQuotationPush(QuotationLogDTO quotationLogDTO) {
        logger.info("接收报价推送, 债券代码: {}, 报价来源: {}", quotationLogDTO.getBondCode(), quotationLogDTO.getPriceSource());
        
        try {
            // 参数校验
            if (quotationLogDTO == null || quotationLogDTO.getBondCode() == null || quotationLogDTO.getTransNo() == null) {
                throw new IllegalArgumentException("报价推送参数不完整");
            }

            // 保存报价日志
            quotationLogRepository.save(quotationLogDTO);
            
            logger.info("报价推送记录成功, 流水号: {}", quotationLogDTO.getTransNo());
            return quotationLogDTO.getTransNo();
            
        } catch (Exception e) {
            logger.error("报价推送记录失败", e);
            throw new RuntimeException("报价推送记录失败: " + e.getMessage());
        }
    }
} 