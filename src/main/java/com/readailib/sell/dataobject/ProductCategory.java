package com.readailib.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/*
 * @program: sell
 * @description:类目
 * @Author: ReadAILib
 * @create: 2018-03-26 18:25
 **/
@Entity
@DynamicUpdate
@Data
public class ProductCategory {
     /** 类目id */
     @Id
     @GeneratedValue
     private Integer categoryId;

     /** 类目名称 */
     private  String categoryName;

     /** 类目编号 */
     private Integer categoryType;

     /** 创建时间戳 */
     //private Date createTime;

    public ProductCategory() {
        super();
    }

    /** 更新时间戳 */
     //private Date updateTime;



    public ProductCategory(String categoryName, Integer categoryType) {
        super();
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
