package com.example.demo.business.general.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.business.general.client.OrganizationService;
import com.example.demo.business.general.domain.repository.OrganizationRepository;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public String getParentOrg(String orgNum) {
        if (orgNum == null) {
            throw new IllegalArgumentException("机构号不能为空");
        }
        return organizationRepository.getParentOrgNum(orgNum);
    }

    @Override
    public int getOrgLevel(String orgNum) {
        if (orgNum == null) {
            throw new IllegalArgumentException("机构号不能为空");
        }
        Integer level = organizationRepository.getOrgLevel(orgNum);
        if (level == null) {
            throw new IllegalArgumentException("未找到机构层级信息");
        }
        return level;
    }
} 