package com.suosi.zy.xueya.network;

/**
 *
 * 网络请求结果 基类
 * Created by G on 2016/11/24.
 */

public class BaseResponse<T> {

    public int status;
    public String message;
    public T data;

    public boolean isSuccess() {
        return status == 200;
    }
}
