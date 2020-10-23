package com.testweb.BasicTest;

public enum ResultEnum {

    SUCCESS(1000,"成功"),

    CANULL(10001,"没有查询到对应卡号"),

    AREANULL(10002,"没有查询到对应区域"),

    MESSAGEERROR(10003,"消息信息不符合规范，请检查消息标题，内容等信息"),

    TIMEERROR(10004,"时间格式不符合规范"),

    ERROR(10005,"操作异常，请检查录入数据重新操作或联系管理员");



    private int code;

    private String msg;

    ResultEnum(int code, String msg){
        this.code = code;

        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
