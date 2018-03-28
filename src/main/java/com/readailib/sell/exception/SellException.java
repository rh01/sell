package com.readailib.sell.exception;

import com.readailib.sell.enums.ResultEnum;

/*
 * @program: sell
 * @description:
 * @Author: ReadAILib
 * @create: 2018-03-27 19:00
 **/
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();

    }


    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
