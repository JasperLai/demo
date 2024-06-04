package com.example.demo.business.product.adapter.response;

import com.example.demo.common.exception.data.BaseData;
import com.example.demo.common.response.QueryBaseResponse;

public class QueryKeAcFacilityResponse extends QueryBaseResponse {

    //标准查询示例
    private String produce_code;
    private String bond_code;
    private String facility_useable;
    private String can_sell_max_amount;
    private String can_buy_max_amount;
    private String max_quota;
    private String min_quota;

    public QueryKeAcFacilityResponse(BaseData inv) {
        super(inv);
    }
    
    public String getProduce_code() {
        return produce_code;
    }


    public void setProduce_code(String produce_code) {
        this.produce_code = produce_code;
    }


    public String getBond_code() {
        return bond_code;
    }


    public void setBond_code(String bond_code) {
        this.bond_code = bond_code;
    }


    public String getFacility_useable() {
        return facility_useable;
    }


    public void setFacility_useable(String facility_useable) {
        this.facility_useable = facility_useable;
    }


    public String getCan_sell_max_amount() {
        return can_sell_max_amount;
    }


    public void setCan_sell_max_amount(String can_sell_max_amount) {
        this.can_sell_max_amount = can_sell_max_amount;
    }


    public String getCan_buy_max_amount() {
        return can_buy_max_amount;
    }


    public void setCan_buy_max_amount(String can_buy_max_amount) {
        this.can_buy_max_amount = can_buy_max_amount;
    }


    public String getMax_quota() {
        return max_quota;
    }


    public void setMax_quota(String max_quota) {
        this.max_quota = max_quota;
    }


    public String getMin_quota() {
        return min_quota;
    }


    public void setMin_quota(String min_quota) {
        this.min_quota = min_quota;
    }


    


    

}
