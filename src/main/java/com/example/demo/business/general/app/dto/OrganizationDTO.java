package com.example.demo.business.general.app.dto;

import com.example.demo.business.general.domain.entity.Organization;

public class OrganizationDTO {
    private String orgNum;
    private String parentOrgNum;
    private String orgName;
    private Integer orgLevel;
    private Boolean enabled;

    // Getters and Setters
    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum;
    }

    public String getParentOrgNum() {
        return parentOrgNum;
    }

    public void setParentOrgNum(String parentOrgNum) {
        this.parentOrgNum = parentOrgNum;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(Integer orgLevel) {
        this.orgLevel = orgLevel;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    // 转换方法
    public static OrganizationDTO fromEntity(Organization entity) {
        if (entity == null) {
            return null;
        }
        OrganizationDTO dto = new OrganizationDTO();
        dto.setOrgNum(entity.getOrgNum());
        dto.setParentOrgNum(entity.getParentOrgNum());
        dto.setOrgName(entity.getOrgName());
        dto.setOrgLevel(entity.getOrgLevel());
        dto.setEnabled(entity.getEnabled());
        return dto;
    }

    public Organization toEntity() {
        return Organization.builder()
                .withOrgNum(this.orgNum)
                .withParentOrgNum(this.parentOrgNum)
                .withOrgName(this.orgName)
                .withOrgLevel(this.orgLevel)
                .withEnabled(this.enabled)
                .build();
    }
} 