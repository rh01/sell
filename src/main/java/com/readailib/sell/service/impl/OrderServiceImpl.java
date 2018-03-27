package com.readailib.sell.service.impl;

import com.readailib.sell.converter.OrderMaster2OrderDTO;
import com.readailib.sell.dataobject.OrderDetail;
import com.readailib.sell.dataobject.OrderMaster;
import com.readailib.sell.dataobject.ProductInfo;
import com.readailib.sell.dto.CartDTO;
import com.readailib.sell.dto.OrderDTO;
import com.readailib.sell.enums.OrderStatusEnum;
import com.readailib.sell.enums.PayStatusEnum;
import com.readailib.sell.enums.ResultEnum;
import com.readailib.sell.exception.SellException;
import com.readailib.sell.repository.OrderDetailRepository;
import com.readailib.sell.repository.OrderMasterRepository;
import com.readailib.sell.service.OrderService;
import com.readailib.sell.service.ProductService;
import com.readailib.sell.utils.KeyUtil;
import org.hibernate.criterion.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Override
    public OrderDTO create(OrderDTO orderMaster) {
        String orderId = KeyUtil.genUniqueKey();

        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        //1. 查询商品（数量，价格）
        for (OrderDetail detail : orderMaster.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(detail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2. 计算总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(detail.getProductQuantity()))
                    .add(orderAmount);
            //3.订单详情入库.
            detail.setOrderId(orderId);
            detail.setDetailId(KeyUtil.genUniqueKey());
            /*将productInfo的属性拷贝到detail*/
            BeanUtils.copyProperties(productInfo, detail);
            orderDetailRepository.save(detail);
        }
        //3. 写入到订单数据库（orderMaster和orderDetail）

        OrderMaster orderMaster1 = new OrderMaster();
        BeanUtils.copyProperties(orderMaster, orderMaster1);
        orderMaster1.setOrderId(orderId);
        orderMaster1.setOrderAmount(orderAmount);


        orderMasterRepository.save(orderMaster1);

        //4. 口库存
        List<CartDTO> cartDTOList = orderMaster.getOrderDetailList()
                .stream()
                .map(e -> new CartDTO(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);


        return orderMaster;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        Example<OrderMaster> example = Example.of(orderMaster);
        OrderMaster orderMaster1 = repository.findOne(example).get();
        if( orderMaster1 == null){
            throw  new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
        if (orderDetailList == null){
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }

        OrderDTO orderDTO1 = new OrderDTO();
        BeanUtils.copyProperties(orderMaster1, orderDTO1);
        orderDTO1.setOrderDetailList(orderDetailList);
        return orderDTO1;

    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        Page<OrderMaster> orderMasterPage = orderMasterRepository.findByBuyerOpenid(buyerOpenid, pageable);

        List<OrderDTO> orderDTOList = OrderMaster2OrderDTO.convert(orderMasterPage.getContent());
        Page<OrderDTO> orderDTOPage = new PageImpl<OrderDTO>(orderDTOList,pageable, orderDTOList.size());
        return orderDTOPage;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
