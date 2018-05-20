package com.cx.serviceImpl;

import com.cx.dataObject.ProductCategory;
import com.cx.repository.ProductCategoryRepository;
import com.cx.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenxiong on 18/5/8.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    @Override
    public List<ProductCategory> findByCategoryType(List<Integer> categoryList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryList);
    }
}
