package com.readailib.sell.controller;

import com.readailib.sell.VO.ProductInfoVO;
import com.readailib.sell.VO.ProductVO;
import com.readailib.sell.VO.ResultVO;
import com.readailib.sell.dataobject.ProductCategory;
import com.readailib.sell.dataobject.ProductInfo;
import com.readailib.sell.service.CategoryService;
import com.readailib.sell.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
 * @program: sell
 * @description: 买家商品
 * @Author: ReadAILib
 * @create: 2018-03-27 09:49
 **/
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {

        ResultVO resultVO = new ResultVO();
        /*创建一个ProductVO*/

        ProductInfoVO productInfoVO = new ProductInfoVO();

        //1. 查询所有的商家商品
        List<ProductInfo> productInfos = productService.findUpAll();


        //2. 查询类目（一次性查询）
//       List<Integer> categoryTypeList= new ArrayList<>();
        //传统方法
        /*for (ProductInfo productInfo: productInfos){
            categoryTypeList.add(productInfo.getCategoryType());
        }*/
        //精简 j8 lambda
        List<Integer> categoryTypeList = productInfos.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);


        //3. 数据拼装
        List<ProductVO> productVOList = new ArrayList<>();

        for (ProductCategory productCategory : productCategoryList) {
            ProductVO  productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());


            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfos) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    ProductInfoVO productInfoVO1 = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO1);
                    productInfoVOList.add(productInfoVO1);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }




        /*productVO.setCategoryType(22);
        productVO.setCategoryName("男生最爱");*/
        //productVO.setProductInfoVOList(Arrays.asList(productInfoVO));

        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(productVOList );
        //resultVO.setData(productVO);


        return resultVO;
    }


}
