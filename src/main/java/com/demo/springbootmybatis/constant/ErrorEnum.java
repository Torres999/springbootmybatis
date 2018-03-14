package com.demo.springbootmybatis.constant;

public enum ErrorEnum {

    SYSTEM_ERROR(1000, "系统错误"),
    BUSINESS_ERROR(2000, "业务错误"),
    UNCAUGHT_ERROR(9999, "系统未知错误")
    ;


    private int code; // 错误码
    private String msg; // 错误提示（显示给用户信息）

    ErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
