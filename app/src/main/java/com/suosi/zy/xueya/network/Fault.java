package com.suosi.zy.xueya.network;

/**
 * Created by G on 2016/11/24.
 */
public class Fault extends RuntimeException {


    private int errorCode;


    public Fault(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }


    public int getErrorCode() {
        return errorCode;
    }


}
