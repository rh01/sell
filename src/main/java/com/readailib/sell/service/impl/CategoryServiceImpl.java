package com.readailib.sell.service.impl;


import com.readailib.sell.dataobject.ProductCategory;
import com.readailib.sell.repository.ProductCategoryRepository;
import com.readailib.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 * @program: sell
 * @description: 实现类
 * @Author: ReadAILib
 * @create: 2018-03-26 20:42
 **/
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        ProductCategory pc = new ProductCategory();
        pc.setCategoryId(categoryId);
        Example <ProductCategory> example = Example.of(pc);
        Optional<ProductCategory> productCategory = repository.findOne(example);

        return productCategory.get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> list) {
        return repository.findByCategoryTypeIn(list);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
