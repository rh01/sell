package com.readailib.sell.VO;

import lombok.Data;

/*
 * @program: sell
 * @description:
 * @Author: ReadAILib
 * @create: 2018-03-27 09:53
 **/
@Data
public class ResultVO<T>{
    /*错误吗*/
    private Integer code;

    /*提示信息*/
    private String msg;

    /*返回的具体内容*/
    private T data;


}
