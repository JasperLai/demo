package com.example.demo.business.product.infrastructure.repository;

import com.example.demo.business.product.domain.entity.BondProduct;
import com.example.demo.business.product.domain.repository.BondProductRepository;
import com.example.demo.business.product.infrastructure.mapper.BondProductMapper;

import org.springframework.stereotype.Repository;

@Repository
public class BondProductRepositoryImpl implements BondProductRepository {
    
    private final BondProductMapper bondProductMapper;
    
    public BondProductRepositoryImpl(BondProductMapper bondProductMapper) {
        this.bondProductMapper = bondProductMapper;
    }
    
    @Override
    public void saveProduct(BondProduct bondProduct) {
        bondProductMapper.insert(bondProduct);
    }

    @Override
    public void updateProduct(BondProduct bondProduct) {
        bondProductMapper.update(bondProduct);
    }
} 