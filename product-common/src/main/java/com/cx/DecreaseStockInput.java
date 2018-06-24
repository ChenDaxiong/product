package com.cx;

import lombok.Data;

/**
 * Created by chenxiong on 18/5/11.
 * 取一个具有本服务特征的名字作为某个接口的入参，不适合直接用其它服务相同的名称。
 */
@Data
public class DecreaseStockInput {


    /**
     * 商品ID
     */
    private String productId;

    /**
     * 购买的商品数量
     */
    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
