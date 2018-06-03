package com.cx.serviceImpl;

import com.cx.ProductInfoForOrder;
import com.cx.ServerApplicationTests;
import com.cx.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@Component
public class ProductServiceImplTest extends ServerApplicationTests{

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() {
    }

    @Test
    public void findList() {
        List<ProductInfoForOrder> result=productService.findList(Arrays.asList("164103465734242707","157875227953464068"));
        System.out.println("");
    }

    @Test
    public void decreaseStock() {
    }
}