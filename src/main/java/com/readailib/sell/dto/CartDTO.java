package com.readailib.sell.dto;

import lombok.Data;

/*
 * @program: sell
 * @description:
 * @Author: ReadAILib
 * @create: 2018-03-27 19:30
 **/
@Data
public class CartDTO {
    /** 商品Id*/
    private String productId;
    /** 商品数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
