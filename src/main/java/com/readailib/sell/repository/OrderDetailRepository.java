package com.readailib.sell.repository;

import com.readailib.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    /*根据订单id查询订单详情*/
    public List<OrderDetail> findByOrderId(String orderId);



}
