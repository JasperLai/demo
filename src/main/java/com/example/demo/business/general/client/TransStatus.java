package com.example.demo.business.general.client;

public enum TransStatus {

    FAILED(0, "失败"),
    SUCCESS(1, "成功"),
    PENDING(2, "处理中");

    private int statusCode;
    private String desc;

    TransStatus(int code, String desc){
        this.statusCode = code;
        this.desc = desc;
    }

    public int getCode(){
        return statusCode;
    }

    public String getDesc(){
        return desc;
    }

}
