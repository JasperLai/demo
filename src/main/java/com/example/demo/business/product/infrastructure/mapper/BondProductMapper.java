package com.example.demo.business.product.infrastructure.mapper;

import com.example.demo.business.product.domain.entity.BondProduct;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BondProductMapper {
    void insert(BondProduct bondProduct);
    
    int update(BondProduct bondProduct);
    
    BondProduct findByProductId(String productId);
} 