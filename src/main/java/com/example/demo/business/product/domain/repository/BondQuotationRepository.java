package com.example.demo.business.product.domain.repository;

import com.example.demo.business.product.domain.entity.BondQuotation;
import java.util.Date;
import java.util.List;

public interface BondQuotationRepository {
    void save(BondQuotation quotation);
    
    void update(BondQuotation quotation);
    
    BondQuotation findByTransNo(String quotaTransNo);
    
    List<BondQuotation> findByProductId(String productId);
    
    List<BondQuotation> findByBondCodeAndDate(String bondCode, Date startDate, Date endDate);
    
    List<BondQuotation> findByDate(Date startDate, Date endDate);
    
    List<BondQuotation> findAll();
} 