package com.readailib.sell.dto;

import com.readailib.sell.dataobject.OrderDetail;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/*
 * @program: sell
 * @description:
 * @Author: ReadAILib
 * @create: 2018-03-27 18:45
 **/
@Data
public class OrderDTO {

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

    List<OrderDetail> orderDetailList;

}
