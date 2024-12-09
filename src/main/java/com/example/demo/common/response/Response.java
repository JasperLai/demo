package com.example.demo.common.response;

public class Response<T> {
    private boolean success;
    private String code;
    private String message;
    private T data;
    
    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }
    
    public static <T> Response<T> fail(String code, String message) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
    
    // Getters and Setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
} 