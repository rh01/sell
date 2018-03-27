package com.readailib.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/*
 * @program: sell
 * @description: 返回前端的product对象,商品详情
 * @Author: ReadAILib
 * @create: 2018-03-27 10:13
 **/
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private String productId;

    /** 商品的名称 */
    @JsonProperty("name")
    private String productName;

    /** 商品单价 */
    @JsonProperty("price")
    private BigDecimal productPrice;

    /** 商品描述 */
    @JsonProperty("description")
    private String productDescription;

    /** 商品小图连接 */
    @JsonProperty("icon")
    private String productIcon;



}
