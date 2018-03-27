package com.readailib.sell.repository;

import com.readailib.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    public List<ProductInfo> findByProductStatus(Integer productStatus);

    public List<ProductInfo> findByCategoryType(Integer categoryType);

    public ProductInfo findByProductName(String productName);
}
