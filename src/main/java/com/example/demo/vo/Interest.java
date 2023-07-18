package com.example.demo.vo;

import java.util.List;

public class Interest {
    private String intrstMeth;
    private String intrstPayMeth;
    private int intrstPayFrequency;
    private List<IntervalInfo> intrstDeductInterval;
    
    // Getters and setters

    public String getIntrstMeth() {
        return this.intrstMeth;
    }

    public void setIntrstMeth(String intrstMeth) {
        this.intrstMeth = intrstMeth;
    }

    public String getIntrstPayMeth() {
        return this.intrstPayMeth;
    }

    public void setIntrstPayMeth(String intrstPayMeth) {
        this.intrstPayMeth = intrstPayMeth;
    }

    public int getIntrstPayFrequency() {
        return this.intrstPayFrequency;
    }

    public void setIntrstPayFrequency(int intrstPayFrequency) {
        this.intrstPayFrequency = intrstPayFrequency;
    }

    public List<IntervalInfo> getIntrstDeductInterval() {
        return this.intrstDeductInterval;
    }

    public void setIntrstDeductInterval(List<IntervalInfo> intrstDeductInterval) {
        this.intrstDeductInterval = intrstDeductInterval;
    }
    
    // ...
}
