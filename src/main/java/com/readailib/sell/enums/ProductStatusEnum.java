package com.readailib.sell.enums;

import lombok.Getter;

/**
* @Description:  商品状态
* @Author: ReadAILib
* @Date: 2018/3/27 
*/
@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
