package com.readailib.sell.controller;

import com.readailib.sell.VO.ResultVO;
import com.readailib.sell.converter.OrderForm2OrderDTO;
import com.readailib.sell.dto.OrderDTO;
import com.readailib.sell.enums.OrderStatusEnum;
import com.readailib.sell.enums.ResultEnum;
import com.readailib.sell.exception.SellException;
import com.readailib.sell.form.OrderForm;
import com.readailib.sell.service.OrderService;
import com.readailib.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * @program: sell
 * @description:
 * @Author: ReadAILib
 * @create: 2018-03-28 09:34
 **/
@RestController
@Slf4j
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    /*创建订单*/
    @PostMapping(value = "/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            log.error("【创建订单】纯参数不争取 orderForm={}", orderForm );
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("[创建订单]购物车为空");
            throw new SellException(ResultEnum.CART_EMPTY);

        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());
        return ResultVOUtil.success(map);
    }


    /*订单列表*/
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "2") Integer size){
        if (StringUtils.isEmpty(openid)){
            log.error("[查询订单列表] openid为空");
            }
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, pageRequest);

        // 转换Date -> Long



        return ResultVOUtil.success(orderDTOPage);
    }

    /*订单详情*/

    /**/
}
