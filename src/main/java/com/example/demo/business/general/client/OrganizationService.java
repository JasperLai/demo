package com.example.demo.business.general.client;

public interface OrganizationService {
    /**
     * 获取上级机构编号
     * @param orgNum 机构编号
     * @return 上级机构编号，如果是总行则返回null
     */
    String getParentOrg(String orgNum);

    /**
     * 获取机构层级
     * @param orgNum 机构编号
     * @return 机构层级(1=总行, 2=分行, 3=支行)
     */
    int getOrgLevel(String orgNum);
} 