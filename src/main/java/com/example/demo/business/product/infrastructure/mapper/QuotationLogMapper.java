package com.example.demo.business.product.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.business.product.app.dto.response.QuotationLogDTO;

import java.util.Date;
import java.util.List;

@Mapper
public interface QuotationLogMapper {
    void insert(QuotationLogDTO log);
    
    List<QuotationLogDTO> selectByBondCode(@Param("bondCode") String bondCode);
    
    List<QuotationLogDTO> selectByProductId(@Param("productId") String productId);
    
    List<QuotationLogDTO> selectByDateRange(
        @Param("startDate") Date startDate,
        @Param("endDate") Date endDate
    );
    
    QuotationLogDTO selectByTransNo(@Param("transNo") String transNo);
} 