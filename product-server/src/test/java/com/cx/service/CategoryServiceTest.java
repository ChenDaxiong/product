package com.cx.service;

import com.cx.dataObject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chenxiong on 18/5/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryType() throws Exception {

        List<ProductCategory> resultList = categoryService.findByCategoryType(Arrays.asList(1, 22));
        System.out.println("");
    }

}