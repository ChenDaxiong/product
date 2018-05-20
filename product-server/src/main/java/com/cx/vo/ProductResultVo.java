package com.cx.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by chenxiong on 18/5/8.
 */
public class ProductResultVo {

    //向前端进行展示是这个categoryName的值以name的名称展示
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("product")
    private List<ProductInfoVo> productInfoVoList;

    public ProductResultVo() {

    }

    public ProductResultVo(String categoryName, Integer categoryType, List<ProductInfoVo> productInfoVoList) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.productInfoVoList = productInfoVoList;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public List<ProductInfoVo> getProductInfoVoList() {
        return productInfoVoList;
    }

    public void setProductInfoVoList(List<ProductInfoVo> productInfoVoList) {
        this.productInfoVoList = productInfoVoList;
    }
}
