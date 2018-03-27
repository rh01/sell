package com.readailib.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.readailib.sell.dataobject.ProductInfo;
import lombok.Data;

import java.util.List;

/*
 * @program: sell
 * @description: 商品包含类目
 * @Author: ReadAILib
 * @create: 2018-03-27 10:08
 **/
@Data
public class ProductVO {
    /*类目名称*/
    @JsonProperty("name")
    private String categoryName;

    /* 商品类型*/
    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("food")
    private List<ProductInfoVO> productInfoVOList;

}
