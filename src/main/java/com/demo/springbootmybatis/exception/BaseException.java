package com.demo.springbootmybatis.exception;

public class BaseException extends RuntimeException {
	private static final long serialVersionUID = 6058124557809409651L;

    private final int code;

    public int getCode(){
        return this.code;
    }
    
	public BaseException(int code, String message) {

	    super(message);
	    this.code = code;
    }

    public BaseException(int code, String message, Throwable throwable) {

        super(message, throwable);
        this.code = code;
    }

    public BaseException(int code, Throwable throwable) {

        super(throwable);
        this.code = code;
    }

    public BaseException(int code) {

        this.code = code;
    }

}