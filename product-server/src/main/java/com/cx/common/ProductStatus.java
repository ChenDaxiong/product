package com.cx.common;

/**
 * Created by chenxiong on 18/5/8.
 */
public enum ProductStatus {
    UP(0, "在售"),
    DOWN(1, "下架");
    private Integer code;

    private String message;

    ProductStatus(Integer code, String message) {
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
