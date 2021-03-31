package com.lst.comadep.Entity;

public class ApiResponse {
    private int code;
    private String message;
    private Object data;
    private String token;
    private int intResponse;
    public ApiResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public ApiResponse(int code, String message, Object data,int intResponse) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.intResponse=intResponse;
    }
    public ApiResponse(int code, String message, Object data,String token) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.token=token;
    }

    public ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 返回成功
     * @param message
     * @param data
     */
    public static ApiResponse ok(String message,Object data){
        return new ApiResponse(200,message,data);
    }
    /**
     * 返回成功2
     * @param message
     */
    public static ApiResponse ok(String message){
       return new ApiResponse(200,message,null);
    }

    /**
     * 发送失败
     * @param message
     * @return
     */
    public static ApiResponse error(String message){
        return new ApiResponse(400,message,null);
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getIntResponse() {
        return intResponse;
    }

    public void setIntResponse(int intResponse) {
        this.intResponse = intResponse;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", token='" + token + '\'' +
                ", intResponse=" + intResponse +
                '}';
    }
}
