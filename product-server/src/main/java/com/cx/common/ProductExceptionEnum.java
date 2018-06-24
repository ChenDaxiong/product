package com.cx.common;


/**
 * Created by chenxiong on 18/5/11.
 */
public enum ProductExceptionEnum {

    PRODUCT_NOT_EXIST(1, "商品不存在"),

    PRODUCT_STOCK_NOTENOUGH(2, "商品库存不足");
    private Integer code;

    private String message;

    ProductExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
