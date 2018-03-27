package com.readailib.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/*
 * @program: sell
 * @description: 订单详情
 * @Author: ReadAILib
 * @create: 2018-03-27 14:16
 **/
@Entity
@Data
@DynamicUpdate
public class OrderDetail {
    @Id
    private String detailId;

    /*订单id*/
    private String orderId;

    /*商品id*/
    private String productId;

    /*商品名称*/
    private String productName;

    /*商品价格*/
    private BigDecimal productPrice;

    /*商品数量*/
    private Integer productQuantity;

    /*商品小图*/
    private String productIcon;

    /*创建时间*/
    private Date createTime;

    /*修改时间*/
    private Date updateTime;

    public OrderDetail() {
        super();
    }

    public OrderDetail(String detailId, String orderId, String productId, String productName, BigDecimal productPrice, Integer productQuantity, String productIcon, Date createTime, Date updateTime) {
        this.detailId = detailId;
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productIcon = productIcon;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
