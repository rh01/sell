package com.readailib.sell.service;

import com.readailib.sell.dataobject.OrderMaster;
import com.readailib.sell.dto.OrderDTO;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 订单
 */
public interface OrderService {

    /**创建订单*/
    OrderDTO create(OrderDTO orderMaster);
    /** 查询单个订单*/
    OrderDTO findOne(String orderId);

    /** 查询订单列表*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /** 取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);

    /** 完结订单*/
    OrderDTO finish(OrderDTO orderDTO);

    /** 支付订单*/
    OrderDTO paid(OrderDTO orderDTO);

    /*根据订单id查询*/
    //OrderMaster findOne(String orderId);

    /* 查询所有订单*/
    //Page<OrderMaster> findAll(Pageable pageable);

    /*查询已经下单的订单*/
    //List<OrderMaster> findOrderUpAll();

    /*查询未付款订单*/
    //List<OrderMaster> findPayUpAll();

    /*保存*/
    //OrderMaster save(OrderMaster orderMaster);

    /*根据买家姓名查询订单*/
    //List<OrderMaster> findByBuyerName(String buyerName);

    /*根据微信id来查找订单*/
    //Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);


}
