package com.webapp.util;

import lombok.Data;

@Data
public class Response<T> {
    private int status;
    private String message;
    private T data;
    private long timestamp ;

    public Response (){
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setStatus(ReturnCode.RC100.getCode());
        response.setMessage(ReturnCode.RC100.getMessage());
        response.setData(data);
        return response;
    }

    public static <t> Response<t> fail(int code, String message) {
        Response<t> response = new Response<>();
        response.setStatus(code);
        response.setMessage(message);
        return response;
    }

    public static <t> Response<t> fail(ReturnCode status) {
        Response<t> response = new Response<>();
        response.setStatus(status.getCode());
        response.setMessage(status.getMessage());
        return response;
    }

}
