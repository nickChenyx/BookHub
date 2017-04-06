package com.chenyx.exception;

/**
 * Created by Administrator on 2017/4/5.
 */
public class AppointException extends RuntimeException {

    public AppointException(String message) {
        super(message);
    }

    public AppointException(String message, Throwable cause) {
        super(message, cause);
    }

}