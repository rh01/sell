package com.readailib.sell.service.impl;

import com.readailib.sell.dataobject.OrderDetail;
import com.readailib.sell.repository.OrderDetailRepository;
import com.readailib.sell.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @program: sell
 * @description:
 * @Author: ReadAILib
 * @create: 2018-03-27 18:07
 **/
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository repository;


    @Override
    public List<OrderDetail> findByOrderId(String orderId) {

        return repository.findByOrderId(orderId);

    }
}
