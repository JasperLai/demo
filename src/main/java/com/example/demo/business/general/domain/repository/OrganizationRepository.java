package com.example.demo.business.general.domain.repository;

import com.example.demo.business.general.domain.entity.Organization;

public interface OrganizationRepository {
    /**
     * 根据机构编号查询机构信息
     */
    Organization findByOrgNum(String orgNum);
    
    /**
     * 获取上级机构编号
     */
    String getParentOrgNum(String orgNum);
    
    /**
     * 获取机构层级
     */
    Integer getOrgLevel(String orgNum);
} 