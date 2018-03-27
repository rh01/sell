package com.readailib.sell.service;

import com.readailib.sell.dataobject.ProductInfo;
import com.readailib.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品
 */
public interface ProductService {

    /**根据商品Id来查找商品*/
    ProductInfo findOne(String productId);

    /**保存商品*/
    ProductInfo save(ProductInfo productInfo);

    /** 通过商品状态来查找商品*/
    List<ProductInfo> findByProductStatus(Integer productSatus);

    /** 通过商品名称来查找商品*/
    ProductInfo findByProductName(String productName);

    /** 通过商品类型来查找所有商品 */
    List<ProductInfo> findByCategoryType(Integer categoryType);

    /** 查找所有商品 */
    Page<ProductInfo> findAll(Pageable pageable);

    /** 查找所有在架的商品 */
    List<ProductInfo> findUpAll();

    /*家库存*/
    void increaseStock(List<CartDTO> cartDTOList);

    /*减库存*/
    void decreaseStock(List<CartDTO> cartDTOList);

}
