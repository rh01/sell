package com.readailib.sell.service.impl;

import com.readailib.sell.converter.OrderMaster2OrderDTO;
import com.readailib.sell.dataobject.OrderDetail;
import com.readailib.sell.dataobject.OrderMaster;
import com.readailib.sell.dto.OrderDTO;
import com.readailib.sell.enums.OrderStatusEnum;
import com.readailib.sell.enums.PayStatusEnum;
import com.readailib.sell.repository.OrderMasterRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderMasterRepository repository;

    private String OPENID = "110110";
    private String ORDERID = "1522153783223780734";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("申恒恒");
        orderDTO.setBuyerAddress("国科大");
        orderDTO.setBuyerPhone("12222222");
        orderDTO.setBuyerOpenid(OPENID);

        /*购物车*/
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductQuantity(1);
        orderDetail.setProductId("12");

        OrderDetail od2 = new OrderDetail();
        od2.setProductQuantity(1);
        od2.setProductId("13");

        orderDetailList.add(orderDetail);
        orderDetailList.add(od2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单]：result = {}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO result = orderService.findOne(ORDERID);
        log.info("[查询某个订单] result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findList() {
        PageRequest request = PageRequest.of(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(OPENID, request);
        Assert.assertNotEquals(0, orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(ORDERID);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(ORDERID);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISH.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(ORDERID);
        Example<OrderMaster> orderMasterExample = Example.of(orderMaster);


        OrderMaster orderMaster1 = repository.findOne(orderMasterExample).get();
        OrderDTO orderDTO = OrderMaster2OrderDTO.convert(orderMaster1);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }
}
