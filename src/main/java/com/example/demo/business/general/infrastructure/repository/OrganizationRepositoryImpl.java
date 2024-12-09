package com.example.demo.business.general.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.business.general.domain.entity.Organization;
import com.example.demo.business.general.domain.repository.OrganizationRepository;
import com.example.demo.business.general.infrastructure.mapper.OrganizationMapper;
import com.example.demo.business.general.app.dto.OrganizationDTO;

@Repository
public class OrganizationRepositoryImpl implements OrganizationRepository {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public Organization findByOrgNum(String orgNum) {
        if (orgNum == null) {
            throw new IllegalArgumentException("机构编号不能为空");
        }
        OrganizationDTO dto = organizationMapper.selectByOrgNum(orgNum);
        return dto != null ? dto.toEntity() : null;
    }

    @Override
    public String getParentOrgNum(String orgNum) {
        if (orgNum == null) {
            throw new IllegalArgumentException("机构编号不能为空");
        }
        return organizationMapper.selectParentOrgNum(orgNum);
    }

    @Override
    public Integer getOrgLevel(String orgNum) {
        if (orgNum == null) {
            throw new IllegalArgumentException("机构编号不能为空");
        }
        return organizationMapper.selectOrgLevel(orgNum);
    }
} 