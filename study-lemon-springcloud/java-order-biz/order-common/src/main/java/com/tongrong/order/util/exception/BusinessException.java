package com.tongrong.order.util.exception;

/**
 * 业务的异常处理
 */
public class BusinessException extends RuntimeException {


    private static final long serialVersionUID = 5646283057216412238L;

    private String code;


    String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BusinessException(String code, String message) {

        super(message);
        this.code = code;

    }
}


