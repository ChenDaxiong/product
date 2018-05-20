package com.cx.service;

import com.cx.dataObject.ProductCategory;

import java.util.List;

/**
 * Created by chenxiong on 18/5/8.
 */
public interface CategoryService {

    //获取商品类型的列表
    List<ProductCategory> findByCategoryType(List<Integer> categoryList);
}
