package com.readailib.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/*
 * @program: sell
 * @description:
 * @Author: ReadAILib
 * @create: 2018-03-28 09:35
 **/
@Data
public class OrderForm {

    /*买家姓名*/
    @NotEmpty(message = "姓名必填")
    private String name;

    /*买家手机号*/
    @NotEmpty(message = "手机号必填")
    private String phone;

    /*买家地址*/
    @NotEmpty(message = "地址必填")
    private String address;

    /*买家微信openid*/
    @NotEmpty(message = "微信openid必填")
    private String openid;

    /*item信息*/
    @NotEmpty(message = "item必填")
    private String items;
}
