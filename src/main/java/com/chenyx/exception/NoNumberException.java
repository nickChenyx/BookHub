package com.chenyx.exception;

/**
 * Created by Administrator on 2017/4/5.
 */
public class NoNumberException extends RuntimeException {
    public NoNumberException(String message){
        super(message);
    }
    public NoNumberException(String message, Throwable cause){
        super(message,cause);
    }
}
