package com.example.demo.business.general.infrastructure.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.demo.business.general.app.dto.OrganizationDTO;

@Mapper
public interface OrganizationMapper {
    
    /**
     * 根据机构编号查询机构信息
     */
    OrganizationDTO selectByOrgNum(@Param("orgNum") String orgNum);
    
    /**
     * 根据机构编号查询上级机构编号
     */
    String selectParentOrgNum(@Param("orgNum") String orgNum);
    
    /**
     * 根据机构编号查询机构层级
     */
    Integer selectOrgLevel(@Param("orgNum") String orgNum);
} 