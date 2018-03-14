package com.demo.springbootmybatis.constant.freeze;

public enum  AcctStatus {

    FAIL("0","失败"),
    SUCCESS("1","成功"),
    ;

    private String status;
    private String msg;

    private AcctStatus(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
