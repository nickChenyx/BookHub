package com.chenyx.dto;

/**
 * Created by Administrator on 2017/4/5.
 */
public class Result<T> {
    // 是否成功
    private boolean isSuccess;
    // 成功时返回的数据
    private T data;
    // 失败的错误信息
    private String error;
    
    public Result(){}

    /**
     * 成功时的构造方法
     * @param isSuccess
     * @param data
     */
    public Result(boolean isSuccess, T data){
        this.isSuccess = isSuccess;
        this.data = data;
    }

    /**
     * 失败时的构造方法
     * @param isSuccess
     * @param error
     */
    public Result(boolean isSuccess, String error){
        this.isSuccess = isSuccess;
        this.error = error;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
