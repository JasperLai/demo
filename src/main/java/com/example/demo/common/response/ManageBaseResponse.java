package com.example.demo.common.response;

import com.example.demo.common.util.DateUtil;
import com.example.demo.exception.BaseData;

public class ManageBaseResponse {

    private String order_code;
    private String trade_date;
    private String trade_time;
    private String domain;
    private String type;
    private String code;
    private String message;
    private String externalSystem;
    private String externalCode;
    private String externalMessage;


    public ManageBaseResponse(BaseData b){
        this.trade_date = DateUtil.getCurrentDate();
        this.trade_time = DateUtil.getCurrentDateTime();
        this.order_code = b.getTransNo();
        this.message = b.getReturnMsg();
        this.code = b.getErrCode();
    }
    public ManageBaseResponse() {
        this.trade_date = DateUtil.getCurrentDate();
        this.trade_time = DateUtil.getCurrentDateTime();
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    // 其他 getter 和 setter 方法...

    public String getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(String trade_date) {
        this.trade_date = trade_date;
    }

    public String getTrade_time() {
        return trade_time;
    }

    public void setTrade_time(String trade_time) {
        this.trade_time = trade_time;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExternalSystem() {
        return externalSystem;
    }

    public void setExternalSystem(String externalSystem) {
        this.externalSystem = externalSystem;
    }

    public String getExternalCode() {
        return externalCode;
    }

    public void setExternalCode(String externalCode) {
        this.externalCode = externalCode;
    }

    public String getExternalMessage() {
        return externalMessage;
    }

    public void setExternalMessage(String externalMessage) {
        this.externalMessage = externalMessage;
    }
}

