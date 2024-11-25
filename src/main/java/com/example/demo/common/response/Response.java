package com.example.demo.common.response;

public class Response<T> {
    private boolean success = true;
    private String errCode;
    private String returnMsg;
    private T data;

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        return response;
    }

    public static <T> Response<T> error(String errCode, String errMsg) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrCode(errCode);
        response.setReturnMsg(errMsg);
        return response;
    }

    // getters and setters
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

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
} 