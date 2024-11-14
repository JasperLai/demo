package com.example.demo.business.product.domain.entity;

import java.util.Objects;

import com.example.demo.business.product.domain.entity.Inventory.SaleStrategy;

public class OrgNode {
    private String orgId;

    public OrgNode() {
    }

    public OrgNode(String orgId, String parentId, SaleStrategy strategy, long limit) {
        this.orgId = orgId;
        this.parentId = parentId;
        this.strategy = strategy;
        this.limit = limit;
    }

    public String getOrgId() {
        return this.orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public SaleStrategy getStrategy() {
        return this.strategy;
    }

    public void setStrategy(SaleStrategy strategy) {
        this.strategy = strategy;
    }

    public long getLimit() {
        return this.limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public OrgNode orgId(String orgId) {
        setOrgId(orgId);
        return this;
    }

    public OrgNode parentId(String parentId) {
        setParentId(parentId);
        return this;
    }

    public OrgNode strategy(SaleStrategy strategy) {
        setStrategy(strategy);
        return this;
    }

    public OrgNode limit(long limit) {
        setLimit(limit);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrgNode)) {
            return false;
        }
        OrgNode orgNode = (OrgNode) o;
        return Objects.equals(orgId, orgNode.orgId) && Objects.equals(parentId, orgNode.parentId) && Objects.equals(strategy, orgNode.strategy) && limit == orgNode.limit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orgId, parentId, strategy, limit);
    }

    @Override
    public String toString() {
        return "{" +
            " orgId='" + getOrgId() + "'" +
            ", parentId='" + getParentId() + "'" +
            ", strategy='" + getStrategy() + "'" +
            ", limit='" + getLimit() + "'" +
            "}";
    }
    private String parentId;
    private SaleStrategy strategy;
    private long limit;

    // Constructor, getters, and setters not shown for brevity
}

