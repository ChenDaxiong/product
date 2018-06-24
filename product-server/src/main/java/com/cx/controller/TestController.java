package com.cx.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("getProductMsg")
    public String msg(){
        String response="调用商品服务的接口";
        return response;
    }


}
