package com.och.common.enums;

import lombok.Getter;

@Getter
public enum SipAgentStatusEnum {

    //状态 0-空闲  1-忙碌 2-通话中 3-离线
    READY(0,"空闲"),
    NOT_READY(1,"忙碌"),
    TALKING(2,"通话中"),
    OFF_ON(3,"离线"),

    ;

    //状态码
    private int code;

    //状态描述
    private String des;

    SipAgentStatusEnum(int code, String des) {
        this.code = code;
        this.des = des;
    }

    public static boolean isEquals(int code, String des) {
        return SipAgentStatusEnum.valueOf(des).code == code;
    }
}
