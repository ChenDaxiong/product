package com.cx;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by chenxiong on 18/5/12.
 * ProductInfo是根据数据库表生成的pojo类，不适合直接对外暴露。所以使用一个传输对象ProductInfoForOrder
 * 相当于对pojo对象进行了一次封装。
 */
@Data
public class ProductInfoForOrder {

    private int a=1;

    private String productId;

    //商品名称
    private String productName;

    //单价
    private BigDecimal productPrice;

    //库存
    private Integer productStock;

    //描述
    private String productDescription;

    //图片
    private String productIcon;

    //商品的状态，0正常1下架
    private Integer productStatus;

    //商品类别
    private Integer categoryType;


    public ProductInfoForOrder() {
    }

    public ProductInfoForOrder(String productId, String productName, BigDecimal productPrice, Integer productStock, String productDescription, String productIcon, Integer productStatus, Integer categoryType) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
        this.productStatus = productStatus;
        this.categoryType = categoryType;
    }
}
