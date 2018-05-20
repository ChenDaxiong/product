package com.cx.service;

import com.cx.DecreaseStockInput;
import com.cx.ProductInfoForOrder;
import com.cx.dataObject.ProductInfo;

import java.util.List;

/**
 * Created by chenxiong on 18/5/8.
 */
public interface ProductService {

    /**
     * @return List<ProductInfo>
     * 返回所有在售的商品
     */
    List<ProductInfo> findUpAll();

    /**
     * 根据购物车中商品Id的集合获取商品的集合
     */
    List<ProductInfoForOrder> findList(List<String> productIds);

    /**
     * 减商品库存
     * decrease/di'kri:s/ :减少
     */

    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);

}
