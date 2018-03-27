package com.readailib.sell.service;

import com.readailib.sell.dataobject.OrderDetail;

import java.util.List;

/**
 * 点单详情
 */

public interface OrderDetailService {

    /*实现*/
    List<OrderDetail> findByOrderId(String orderId);
}
