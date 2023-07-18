package com.example.demo.vo;

public class QuotaAllocation {
    private String channel;
    private double quota;
    private int allocRatio;
    
    // Getters and setters

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public double getQuota() {
        return this.quota;
    }

    public void setQuota(double quota) {
        this.quota = quota;
    }

    public int getAllocRatio() {
        return this.allocRatio;
    }

    public void setAllocRatio(int allocRatio) {
        this.allocRatio = allocRatio;
    }
    
    // ...
}
