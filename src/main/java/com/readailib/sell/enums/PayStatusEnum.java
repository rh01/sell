package com.readailib.sell.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {

    WAIT(0, "未支付"),
    SUCCESS(1,"已支付")
    ;

    /*支付状态吗，0表示未支付*/
    private Integer code;

    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
