package com.readailib.sell.service.impl;

import com.readailib.sell.dataobject.ProductInfo;
import com.readailib.sell.enums.ProductStatusEnum;
import com.readailib.sell.repository.ProductInfoRepository;
import com.readailib.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @program: sell
 * @description: ProductService的实现 商品
 * @Author: ReadAILib
 * @create: 2018-03-26 22:40
 **/
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductInfoRepository repository;

    @Override
    public ProductInfo findOne(String productId) {
        ProductInfo info = new ProductInfo();
        info.setProductId(productId);
        Example<ProductInfo> example = Example.of(info);
        ProductInfo result = repository.findOne(example).get();
        return result;
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public List<ProductInfo> findByProductStatus(Integer productSatus) {
        return repository.findByProductStatus(productSatus);
    }

    @Override
    public ProductInfo findByProductName(String productName) {
        return repository.findByProductName(productName);
    }

    @Override
    public List<ProductInfo> findByCategoryType(Integer categoryType) {
        return repository.findByCategoryType(categoryType);
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }
}
