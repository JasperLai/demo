package com.example.demo.business.product.domain.domainObject;

import java.util.Map;

import com.example.demo.business.product.domain.service.OrgService;

public class Inventory {
    private String orgId;
    private String bondCode;
    private long availableQuota;
    private SaleStrategy strategy;

    // Constructor
    public Inventory(String orgId, String bondCode, SaleStrategy strategy) {
        this.orgId = orgId;
        this.bondCode = bondCode;
        this.strategy = strategy;
        this.availableQuota = (strategy == SaleStrategy.GLOBAL) ? 0 : -1; // -1 can denote "unset" for SPECIFIC strategy
    }

    // Getters and setters
    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public long getAvailableQuota() {
        // For global strategy, it could potentially fetch the limit from a global setting
        if(this.strategy == SaleStrategy.GLOBAL) {
            // Simulate fetching global limit
            return fetchGlobalLimit();
        } else {
            return availableQuota;
        }
    }


    public void setAvailableQuota(long limit) {
        if (this.strategy == SaleStrategy.SPECIFIC) {
            this.availableQuota = limit;
        }
        // If the strategy is GLOBAL, setting limit might be ignored or throw an error
    }

    public SaleStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(SaleStrategy strategy) {
        this.strategy = strategy;
    }

    // Assume there is a method to fetch the global limit. Placeholder implementation:
    private long fetchGlobalLimit() {
        long globalLimit = 0;

        Map<String, OrgNode> hierarchy = OrgService.getHierarchy();

        // Find the root node for the current organization
        OrgNode currentOrgNode = hierarchy.get(this.orgId);
        if (currentOrgNode == null) {
            throw new IllegalStateException("No organization found for ID: " + this.orgId);
        }

        // Traverse up the tree to find the nearest specific strategy limit
        globalLimit = traverseToFindLimit(currentOrgNode, hierarchy);

        return globalLimit;
    
    }

    // Recursive method to traverse the tree and find the nearest specific strategy limit
    private long traverseToFindLimit(OrgNode node, Map<String, OrgNode> hierarchy) {
        if (node.getStrategy() == SaleStrategy.SPECIFIC) {
            // Found the nearest specific strategy limit
            return node.getLimit();
        } else if (node.getParentId() == null) {
            // If we've reached the root node without finding a specific strategy, return the root limit
            return node.getLimit();
        } else {
            // Recursively call this method with the parent node
            return traverseToFindLimit(hierarchy.get(node.getParentId()), hierarchy);
        }
    }

    // Enum for SaleStrategy
    public enum SaleStrategy {
        GLOBAL,
        SPECIFIC
    }
}

