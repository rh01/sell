package com.readailib.sell.service;

import com.readailib.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 订单
 */
public interface OrderService {

    /*根据订单id查询*/
    OrderMaster findOne(String orderId);

    /* 查询所有订单*/
    Page<OrderMaster> findAll(Pageable pageable);

    /*查询已经下单的订单*/
    List<OrderMaster> findOrderUpAll();

    /*查询未付款订单*/
    List<OrderMaster> findPayUpAll();

    /*保存*/
    OrderMaster save(OrderMaster orderMaster);

    /*根据买家姓名查询订单*/
    List<OrderMaster> findByBuyerName(String buyerName);


}
