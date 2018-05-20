package com.cx.repository;

import com.cx.ServerApplicationTests;
import com.cx.dataObject.ProductInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chenxiong on 18/5/8.
 */
@Component
public class productInfoRepositoryTest extends ServerApplicationTests {

    @Autowired
    private ProductInfoRepository productInfoRepository;


    @Test
    public void findByProductIdIn() throws Exception {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductIdIn(Arrays.asList("157875196366160022", "157875227953464068"));
        System.out.print("");
    }

}