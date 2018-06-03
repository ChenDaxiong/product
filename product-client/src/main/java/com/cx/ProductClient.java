package com.cx;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "PRODUCT")
public interface ProductClient {

    @RequestMapping("getProductMsg")
    String getProductMsg();

    @RequestMapping("product/listByIds")
    public List<ProductInfoForOrder> getProductList(@RequestBody List<String> productIdList);

    @PostMapping("product/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

}
