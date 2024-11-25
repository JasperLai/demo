package com.example.demo.business.product.infrastructure.mapper;

import com.example.demo.business.product.app.dto.response.BondQuotationDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface BondQuotationMapper {
    void insert(BondQuotationDTO quotation);
    
    void update(BondQuotationDTO quotation);
    
    BondQuotationDTO selectByTransNo(@Param("quotaTransNo") String quotaTransNo);
    
    List<BondQuotationDTO> selectByProductId(@Param("productId") String productId);
    
    List<BondQuotationDTO> selectAll();
    
    List<BondQuotationDTO> selectByBondCodeAndDate(
        @Param("bondCode") String bondCode,
        @Param("startDate") Date startDate,
        @Param("endDate") Date endDate
    );
    
    List<BondQuotationDTO> selectByDate(
        @Param("startDate") Date startDate,
        @Param("endDate") Date endDate
    );
} 