package com.cx.repository;

import com.cx.dataObject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by chenxiong on 18/5/8.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    //获取商品类型的列表
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryList);
}
