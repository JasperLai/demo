package com.example.demo.business.general.client;

public enum TransStatus {

    FAILED(0),
    SUCCESS(1),
    PENDING(2);

    private int statusCode;

    TransStatus(int code){
        this.statusCode = code;
    }

    public int getStatusCode(){
        return statusCode;
    }

}
