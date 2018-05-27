package com.wrh.dto;

import com.wrh.enums.FailedEnum;

import java.io.Serializable;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午3:13 on 2018/5/27.
 */
public class ResponseDto<T> implements Serializable{
    private final static int SUCCESS_CODE = 200;

    private int code;
    private String message;
    private T data;

    public ResponseDto() {
    }

    public ResponseDto(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return SUCCESS_CODE == code;
    }

    public boolean failed() {
        return !isSuccess();
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static <T> ResponseDto<T> success(String msg,T data) {
        return new ResponseDto<T>(SUCCESS_CODE,msg,data);
    }

    public static <T> ResponseDto<T> success(T data) {
        return success("",data);
    }

    public static <T> ResponseDto<T> fail(FailedEnum failedEnum, String msg) {
        return new ResponseDto<T>(failedEnum.getCode(),msg,null);
    }
}
