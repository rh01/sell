package com.readailib.sell.utils;

import java.util.Random;

/*
 * @program: sell
 * @description:
 * @Author: ReadAILib
 * @create: 2018-03-27 19:14
 **/
public class KeyUtil {
    /**
    * @Description: 生成唯一的逐渐，格式：时间+随机数
    * @Param:
    * @return:
    * @Author: ReadAILib
    * @Date: 2018/3/27
    */
    public static  synchronized  String genUniqueKey(){
        Random random = new Random();
        int a = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(a);
    }
}
