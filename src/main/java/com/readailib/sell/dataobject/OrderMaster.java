package com.readailib.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/*
 * @program: sell
 * @description: 订单主表格
 * @Author: ReadAILib
 * @create: 2018-03-27 13:11
 **/
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;

    /*买家姓名*/
    private String buyerName;
    /*买家电话*/
    private String buyerPhone;
    /*买家地址*/
    private String buyerAddress;
    /*买家的微信openId*/
    private String buyerOpenid;
    /*总金额*/
    private BigDecimal orderAmount;
    /*订单状态，默认0为下订单*/
    private Integer orderStatus = 0;
    /*购买的状态，默认0未支付*/
    private Integer payStatus = 0;
    /*创建时间*/
    private Date createTime;
    /*更新时间*/
    private Date updateTime;

    public OrderMaster() {
        super();
    }

    public OrderMaster(String orderId, String buyerName, String buyerPhone, String buyerAddress, String buyerOpenid, BigDecimal orderAmount, Integer orderStatus, Integer payStatus) {
        super();
        this.orderId = orderId;
        this.buyerName = buyerName;
        this.buyerPhone = buyerPhone;
        this.buyerAddress = buyerAddress;
        this.buyerOpenid = buyerOpenid;
        this.orderAmount = orderAmount;
        this.orderStatus = orderStatus;
        this.payStatus = payStatus;
    }
}
