package com.cx.common;

import lombok.Getter;

/**
 * Created by chenxiong on 18/5/11.
 */
@Getter
public enum ProductExceptionEnum {

    PRODUCT_NOT_EXIST(1, "商品不存在"),

    PRODUCT_STOCK_NOTENOUGH(2, "商品库存不足");
    private Integer code;

    private String message;

    ProductExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
