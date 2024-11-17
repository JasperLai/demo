package com.example.demo.business.product.infrastructure.repository;

import com.example.demo.business.product.domain.entity.Bond;
import com.example.demo.business.product.domain.entity.BondProduct;
import com.example.demo.business.product.domain.repository.BondProductRepository;
import com.example.demo.business.product.infrastructure.mapper.BondProductMapper;
import com.example.demo.business.product.app.dto.response.BondDTO;
import com.example.demo.business.product.app.dto.response.BondProductDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class BondProductRepositoryImpl implements BondProductRepository {
    
    private final BondProductMapper bondProductMapper;
    
    public BondProductRepositoryImpl(BondProductMapper bondProductMapper) {
        this.bondProductMapper = bondProductMapper;
    }
    
    @Override
    public void saveProduct(BondProduct bondProduct) {
        BondProductDTO dto = BondProductDTO.fromEntity(bondProduct);
        bondProductMapper.insert(dto);
    }

    @Override
    public void updateProduct(BondProduct bondProduct) {
        BondProductDTO dto = BondProductDTO.fromEntity(bondProduct);
        bondProductMapper.update(dto);
    }

    @Override
    public BondProduct findByProductId(String productId) {
        BondProductDTO dto = bondProductMapper.selectById(productId);
        return dto != null ? dto.toEntity() : null;
    }

    @Override
    public List<BondProduct> findAll() {
        List<BondProductDTO> dtos = bondProductMapper.selectAll();
        return dtos.stream()
                .map(BondProductDTO::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void saveBond(Bond bond) {
        BondDTO dto = BondDTO.fromEntity(bond);
        bondProductMapper.insertBond(dto);
    }

    @Override
    public void updateBond(Bond bond) {
        BondDTO dto = BondDTO.fromEntity(bond);
        bondProductMapper.updateBond(dto);
    }

    @Override
    public Bond findBondByBondCode(String bondCode) {
        BondDTO dto = bondProductMapper.selectBondByBondCode(bondCode);
        return dto != null ? dto.toEntity() : null;
    }

    @Override
    public List<Bond> findAllBonds() {
        List<BondDTO> dtos = bondProductMapper.selectAllBonds();
        return dtos.stream().map(BondDTO::toEntity).collect(Collectors.toList());
    }
} 
