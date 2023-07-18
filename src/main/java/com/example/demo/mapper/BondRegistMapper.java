package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.bondmanage.BondRegistInfo;

@Mapper
public interface BondRegistMapper {
    void insertBondRegist(@Param("bondRegistInfo") BondRegistInfo bondRegistInfo);

    void updateHandleAndWFStatus(@Param("bondId") String bondId, @Param("handleStatus") int handleStatus, @Param("wfStatus") String wfStatus);
}

