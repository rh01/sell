package com.readailib.sell.repository;

import com.readailib.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void findByOrderId() {
        List<OrderDetail> result = repository.findByOrderId("122");
        Assert.assertNotEquals(0,result.size());


    }

    @Test
    public void saveTest() {
        OrderDetail detail = new OrderDetail();
        detail.setDetailId("1234564");
        detail.setProductId("12334");
        detail.setOrderId("22222222222");
        detail.setProductName("皮蛋瘦肉粥");
        detail.setProductPrice(new BigDecimal(6.0));
        detail.setProductIcon("htpp://xxx.jpg");
        detail.setProductQuantity(2);
        OrderDetail result = repository.save(detail);
        Assert.assertNotNull(result);
    }

    @Test
    public void name() {
    }
}