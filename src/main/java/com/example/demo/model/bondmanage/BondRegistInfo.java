package com.example.demo.model.bondmanage;

public class BondRegistInfo {
    private Bond bond;
    private Interest interest;
    private DateInfo date;
    private String releaseStatus;

    public String getReleaseStatus() {
        return this.releaseStatus;
    }

    public void setReleaseStatus(String releaseStatus) {
        this.releaseStatus = releaseStatus;
    }
    private BusinessPara businessPara;

    
    // Getters and setters
    
    public Bond getBond() {
        return bond;
    }
    
    public void setBond(Bond bond) {
        this.bond = bond;
    }
    
    public Interest getInterest() {
        return interest;
    }
    
    public void setInterest(Interest interest) {
        this.interest = interest;
    }
    
    public DateInfo getDate() {
        return date;
    }
    
    public void setDate(DateInfo date) {
        this.date = date;
    }
    
    
    
    public BusinessPara getBusinessPara() {
        return businessPara;
    }
    
    public void setBusinessPara(BusinessPara businessPara) {
        this.businessPara = businessPara;
    }
}











