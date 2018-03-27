package com.readailib.sell.repository;

import com.readailib.sell.dataobject.ProductCategory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * @program: sell
 * @description:
 * @Author: ReadAILib
 * @create: 2018-03-26 18:30
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    /** 
    * @Description: 测试查找数据 
    * @Param: [] 
    * @return: void 
    * @Author: ReadAILib
    * @Date: 2018/3/26 
    */ 
    @Test
    public void findOneTest() {
        ProductCategory pc = new ProductCategory();
        pc.setCategoryId(3);
        Example<ProductCategory> example1 = Example.of(pc);
        Optional <ProductCategory> productCategory = productCategoryRepository.findOne(example1);
        System.out.println(productCategory.toString());
    }

    /** 
    * @Description: 测试保存数据到数据库 
    * @Param: [] 
    * @return: void 
    * @Author: ReadAILib
    * @Date: 2018/3/26 
    */ 
    @Test
    @Transactional
    public void saveTest() {
        ProductCategory pc = new ProductCategory("老人最爱", 4);

        ProductCategory result = productCategoryRepository.save(pc);
        Assert.assertNotNull(result);
    }

    @Test
    public void updateTest() {

        ProductCategory pc = new ProductCategory();
        pc.setCategoryId(2);
        Example<ProductCategory> example1 = Example.of(pc);
        Optional <ProductCategory> productCategory = productCategoryRepository.findOne(example1);
        productCategory.get().setCategoryType(10);
        productCategoryRepository.save(productCategory.get());
        }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2,3,4);
        List<ProductCategory> result = productCategoryRepository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size() );
    }
}
