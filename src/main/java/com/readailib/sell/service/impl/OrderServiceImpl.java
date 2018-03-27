package com.readailib.sell.service.impl;

import com.readailib.sell.dataobject.OrderMaster;
import com.readailib.sell.enums.OrderStatusEnum;
import com.readailib.sell.enums.PayStatusEnum;
import com.readailib.sell.repository.OrderMasterRepository;
import com.readailib.sell.service.OrderService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.PageRequest.of;

/*
 * @program: sell
 * @description: OrderService的实现
 * @Author: ReadAILib
 * @create: 2018-03-27 13:37
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository repository;


    @Override
    public OrderMaster findOne(String orderId) {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        Example<OrderMaster> example = Example.of(orderMaster);
        OrderMaster result = repository.findOne(example).get();
        return result;
    }

    @Override
    public Page<OrderMaster> findAll(Pageable pageable) {
        //PageRequest pageRequest = of(0,2);
        return repository.findAll(pageable);
    }

    @Override
    public List<OrderMaster> findOrderUpAll() {
        return repository.findByOrderStatus(OrderStatusEnum.FINISH.getCode());
    }

    @Override
    public List<OrderMaster> findPayUpAll() {
        return repository.findByPayStatus(PayStatusEnum.SUCCESS.getCode());
    }

    @Override
    public OrderMaster save(OrderMaster orderMaster) {
        return repository.save(orderMaster);
    }

    @Override
    public List<OrderMaster> findByBuyerName(String buyerName) {
        return repository.findByBuyerName(buyerName);
    }
}
