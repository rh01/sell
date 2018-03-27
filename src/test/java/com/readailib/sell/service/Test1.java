package com.readailib.sell.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/*
 * @program: sell
 * @description: 测试logback日志系统
 * @Author: ReadAILib
 * @create: 2018-03-26 16:48
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
//@Data
public class Test1 {
    private static final Logger logger = LoggerFactory.getLogger(Test1.class);

    @Test
    public void test1() {
        String name = "";
        Integer age = 123333;
        logger.info("name: {}, age: {}", name, age);
        logger.info("info..........");
        logger.error("errrooooo");
        logger.debug("debug............");
    }


}
