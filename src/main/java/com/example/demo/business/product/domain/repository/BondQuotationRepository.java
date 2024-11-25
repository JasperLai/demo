package com.example.demo.business.product.domain.repository;

import com.example.demo.business.product.domain.entity.BondQuotation;
import java.util.List;

public interface BondQuotationRepository {
    void save(BondQuotation quotation);
    
    void update(BondQuotation quotation);
    
    BondQuotation findByTransNo(String quotaTransNo);
    
    List<BondQuotation> findByProductId(String productId);
    
    List<BondQuotation> findAll();
} 