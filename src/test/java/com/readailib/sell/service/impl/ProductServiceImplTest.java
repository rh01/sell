package com.readailib.sell.service.impl;

import com.readailib.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void findOne() {
        ProductInfo info = productService.findOne("12334");
        Assert.assertNotNull(info);
    }

    @Test
    public void save() {
        ProductInfo info = new ProductInfo();
        info.setProductId("2333333");
        info.setProductName("长白山胡萝卜");
        info.setProductPrice(new BigDecimal(230.0));
        info.setCategoryType(23);
        info.setProductDescription("来自长白山的胡萝卜");
        info.setProductStatus(0);
        info.setProductStock(2);
        info.setProductIcon("http:/xxx.png");
        ProductInfo result = productService.save(info);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfos = productService.findByProductStatus(0);
        Assert.assertNotEquals(0, productInfos.size());
    }

    @Test
    public void findByProductName() {
        ProductInfo info = productService.findByProductName("长白山胡萝卜");
        Assert.assertNotNull(info);
    }

    @Test
    public void findByCategoryType() {
        List<ProductInfo> infos = productService.findByCategoryType(23);
        Assert.assertNotEquals(0, infos.size());
    }

    @Test
    public void findAll() {

        Page<ProductInfo> result = productService.findAll(PageRequest.of(0, 2));
        System.out.println(result.getTotalElements());
    }
}