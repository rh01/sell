package com.readailib.sell.repository;

import com.readailib.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @program: sell
 * @description: dao
 * @Author: ReadAILib
 * @create: 2018-03-26 18:29
 **/

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> list);
}
