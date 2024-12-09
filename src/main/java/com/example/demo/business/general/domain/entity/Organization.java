package com.example.demo.business.general.domain.entity;

public class Organization {
    private String orgNum;
    private String parentOrgNum;
    private String orgName;
    private Integer orgLevel;  // 1=总行, 2=分行, 3=支行
    private Boolean enabled;

    // 私有构造函数,使用Builder模式
    private Organization() {}

    public static Builder builder() {
        return new Builder();
    }

    // Builder类
    public static class Builder {
        private Organization org;

        public Builder() {
            org = new Organization();
        }

        public Builder withOrgNum(String orgNum) {
            org.setOrgNum(orgNum);
            return this;
        }

        public Builder withParentOrgNum(String parentOrgNum) {
            org.setParentOrgNum(parentOrgNum);
            return this;
        }

        public Builder withOrgName(String orgName) {
            org.setOrgName(orgName);
            return this;
        }

        public Builder withOrgLevel(Integer orgLevel) {
            org.setOrgLevel(orgLevel);
            return this;
        }

        public Builder withEnabled(Boolean enabled) {
            org.setEnabled(enabled);
            return this;
        }

        public Organization build() {
            return org;
        }
    }

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
} 