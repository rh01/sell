package com.readailib.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.readailib.sell.dataobject.OrderDetail;
import com.readailib.sell.dto.OrderDTO;
import com.readailib.sell.enums.ResultEnum;
import com.readailib.sell.exception.SellException;
import com.readailib.sell.form.OrderForm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

/*
 * @program: sell
 * @description:
 * @Author: ReadAILib
 * @create: 2018-03-28 09:51
 **/
@Slf4j
public class OrderForm2OrderDTO {
    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e){
            log.error("[对象转换] 错误， string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }


        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;

    }
}
