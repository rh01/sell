package com.readailib.sell.repository;

import com.readailib.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository infoRepository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo("12334", "皮蛋瘦肉粥", new BigDecimal(5.8), 120, "好吃不贵","nan", 0,21);

        ProductInfo result = infoRepository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> result = infoRepository.findByProductStatus(0);
        //Assert.assertNotNull(result);
        Assert.assertNotEquals(0, result.size());
    }
}