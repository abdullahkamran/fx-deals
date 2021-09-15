package com.assignment.fxdeals.exception;

public class FxDealsException extends RuntimeException{

    private final String code;

    public FxDealsException(String code, String message) {
        super(message);
        this.code = code;
    }

    public FxDealsException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
