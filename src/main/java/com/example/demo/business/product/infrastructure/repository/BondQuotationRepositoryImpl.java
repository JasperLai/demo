package com.example.demo.business.product.infrastructure.repository;

import com.example.demo.business.product.domain.entity.BondQuotation;
import com.example.demo.business.product.domain.repository.BondQuotationRepository;
import com.example.demo.business.product.infrastructure.mapper.BondQuotationMapper;
import com.example.demo.business.product.app.dto.response.BondQuotationDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BondQuotationRepositoryImpl implements BondQuotationRepository {

    private final BondQuotationMapper bondQuotationMapper;

    public BondQuotationRepositoryImpl(BondQuotationMapper bondQuotationMapper) {
        this.bondQuotationMapper = bondQuotationMapper;
    }

    @Override
    public void save(BondQuotation quotation) {
        BondQuotationDTO dto = BondQuotationDTO.fromEntity(quotation);
        bondQuotationMapper.insert(dto);
    }

    @Override
    public void update(BondQuotation quotation) {
        BondQuotationDTO dto = BondQuotationDTO.fromEntity(quotation);
        bondQuotationMapper.update(dto);
    }

    @Override
    public BondQuotation findByTransNo(String quotaTransNo) {
        BondQuotationDTO dto = bondQuotationMapper.selectByTransNo(quotaTransNo);
        return dto != null ? dto.toEntity() : null;
    }

    @Override
    public List<BondQuotation> findByProductId(String productId) {
        List<BondQuotationDTO> dtos = bondQuotationMapper.selectByProductId(productId);
        return dtos.stream()
                .map(BondQuotationDTO::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<BondQuotation> findAll() {
        List<BondQuotationDTO> dtos = bondQuotationMapper.selectAll();
        return dtos.stream()
                .map(BondQuotationDTO::toEntity)
                .collect(Collectors.toList());
    }
} 