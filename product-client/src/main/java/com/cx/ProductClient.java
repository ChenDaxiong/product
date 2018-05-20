package com.cx;


import com.cx.DecreaseStockInput;
import com.cx.ProductInfoForOrder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by chenxiong on 18/5/11.
 * 声明需要调用的服务和方法
 * FeignClient和服务提供方之间通过@GetMapping中的url来实现的。
 */
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("msg")
    String getProductMsgFeign();

    @PostMapping("product/listForOrder")
    List<ProductInfoForOrder> getProductList(List<String> productIdList);

    @PostMapping("product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}
