package com.readailib.sell.enums;

import lombok.Getter;

/**
 * 订单状态
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISH(1, "下单"),
    CANCEL(2,"已取消")
    ;

    /*状态吗*/
    private Integer code;

    /*辅助消息0*/
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
