package com.example.demo.business.product.infrastructure.repository;

import com.example.demo.business.product.app.dto.response.QuotationLogDTO;
import com.example.demo.business.product.infrastructure.mapper.QuotationLogMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class QuotationLogRepository {
    
    private final QuotationLogMapper quotationLogMapper;
    
    public QuotationLogRepository(QuotationLogMapper quotationLogMapper) {
        this.quotationLogMapper = quotationLogMapper;
    }
    
    public void save(QuotationLogDTO log) {
        quotationLogMapper.insert(log);
    }
    
    public List<QuotationLogDTO> findByBondCode(String bondCode) {
        return quotationLogMapper.selectByBondCode(bondCode);
    }
    
    public List<QuotationLogDTO> findByProductId(String productId) {
        return quotationLogMapper.selectByProductId(productId);
    }
    
    public List<QuotationLogDTO> findByDateRange(Date startDate, Date endDate) {
        return quotationLogMapper.selectByDateRange(startDate, endDate);
    }
    
    public QuotationLogDTO findByTransNo(String transNo) {
        return quotationLogMapper.selectByTransNo(transNo);
    }
} 