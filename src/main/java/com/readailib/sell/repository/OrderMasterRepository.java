package com.readailib.sell.repository;

import com.readailib.sell.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.OptionalDouble;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /*通过订单状态查询*/
    public List<OrderMaster> findByOrderStatus(Integer orderStatus);

    /*通过订单支付状态查询*/
    public List<OrderMaster> findByPayStatus(Integer payStatus);

    /*通过用户姓名查找订单*/
    public List<OrderMaster> findByBuyerName(String buyerName);
}
