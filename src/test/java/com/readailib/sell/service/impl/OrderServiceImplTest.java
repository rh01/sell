package com.readailib.sell.service.impl;

import com.readailib.sell.dataobject.OrderMaster;
import com.readailib.sell.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    /*@Test
    public void findOne() {
        OrderMaster orderMaster = orderService.findOne("222");
        Assert.assertNotNull(orderMaster);

    }*/

    @Test
    public void findAll() {
        PageRequest pageRequest = PageRequest.of(0, 2);
        System.out.println(orderService.findAll(pageRequest).getTotalElements());

    }

    @Test
    public void findOrderUpAll() {
        List<OrderMaster> orderMasterList = orderService.findOrderUpAll();
        Assert.assertNotEquals(0, orderMasterList.size());

    }

    @Test
    public void findPayUpAll() {
        List<OrderMaster> orderMasterList = orderService.findPayUpAll();
        Assert.assertNotEquals(0, orderMasterList.size());
    }

    @Test
    public void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("233");
        orderMaster.setBuyerAddress("北京中国科学院大学");
        orderMaster.setBuyerName("申恒恒");
        orderMaster.setBuyerOpenid("2222");
        orderMaster.setBuyerPhone("18612622451");
        orderMaster.setOrderAmount(new BigDecimal(11.5));
        orderMaster.setOrderStatus(1);
        orderMaster.setPayStatus(1);
        orderService.save(orderMaster);

    }

    @Test
    public void findByBuyerName() {
        List<OrderMaster> orderMasterList = orderService.findByBuyerName("申恒恒");
        Assert.assertNotEquals(0, orderMasterList.size());
    }
}