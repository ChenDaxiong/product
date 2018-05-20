package com.cx.exception;

import com.cx.common.ProductExceptionEnum;

/**
 * Created by chenxiong on 18/5/11.
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ProductExceptionEnum productExceptionEnum) {
        super(productExceptionEnum.getMessage());
        this.code = productExceptionEnum.getCode();
    }
}
