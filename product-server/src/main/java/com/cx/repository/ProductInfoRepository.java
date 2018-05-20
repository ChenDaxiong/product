package com.cx.repository;

import com.cx.dataObject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by chenxiong on 18/5/8.
 * 如何进行单元测试？
 * 1.右键 Go to－>Test
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    //查询所有在架的商品
    List<ProductInfo> findByProductStatus(Integer productStatus);

    //根据商品Id列表查询商品
    List<ProductInfo> findByProductIdIn(List<String> productIdList);


}
