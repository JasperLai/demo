package com.example.demo.vo;

public class Bond {
    private String bondId;
    private String fullname;
    private String shortname;
    private String category;
    private double totalQuota;
    private String issuer;
    private int duration;
    private String saleType;
    private String clearMeth;

    public String getBondId() {
        return this.bondId;
    }

    public void setBondId(String bondId) {
        this.bondId = bondId;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getShortname() {
        return this.shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getTotalQuota() {
        return this.totalQuota;
    }

    public void setTotalQuota(double totalQuota) {
        this.totalQuota = totalQuota;
    }

    public String getIssuer() {
        return this.issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSaleType() {
        return this.saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    public String getClearMeth() {
        return this.clearMeth;
    }

    public void setClearMeth(String clearMeth) {
        this.clearMeth = clearMeth;
    }
    
    // Getters and setters
    
    // ...
}