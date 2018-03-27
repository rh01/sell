package com.readailib.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/*
 * @program: sell
 * @description: 商品的信息
 * @Author: ReadAILib
 * @create: 2018-03-26 21:01
 **/
@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;

    /** 商品的名称 */
    private String productName;

    /** 商品单价 */
    private BigDecimal productPrice;

    /** 商品库存 */
    private Integer productStock;

    /** 商品描述 */
    private String productDescription;

    /** 商品小图连接 */
    private String productIcon;

    /** 商品状态 0正常，1下架*/
    private Integer productStatus;

    /** 类目编号 */
    private Integer categoryType;

    public ProductInfo() {
        super();
    }

    public ProductInfo(String productId ,String productName, BigDecimal productPrice, Integer productStock, String productDescription, String productIcon, Integer productStatus, Integer categoryType) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
        this.productStatus = productStatus;
        this.categoryType = categoryType;
    }
}
