package com.example.demo.common.exception.data;

public class BaseData {

    public static String SUCCESS_CODE = "000000";
    private boolean success = true;
    private String errCode = "";
    private String returnMsg = "";
    private String transNo = "";

    // 构造函数默认成功
    public BaseData() {
        this.success = true;
        this.errCode = SUCCESS_CODE;
    }

    public BaseData(boolean success) {
        this.success = success;
        if (success) {
            this.errCode = SUCCESS_CODE;
        }
    }

    public BaseData(boolean success, String transNo) {
        this.success = success;
        if (success) {
            this.errCode = SUCCESS_CODE;
        }
        this.transNo = transNo;
    }

    // getter 和 setter 方法
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String errMsg) {
        this.returnMsg = errMsg;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo;
    }
}

