package com.cx.dataObject;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by chenxiong on 18/5/8.
 * 类名和表名一致，如果不一致需要加对应的注解：@table（name="table_name"）
 */
@Entity //此注解使得对象和数据库的表对应起来
public class ProductInfo {

    @Id
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

    private Date createTime;

    private Date updateTime;


    public ProductInfo() {

    }

    public ProductInfo(String productId, String productName, BigDecimal productPrice, Integer productStock, String productDescription, String productIcon, Integer productStatus, Integer categoryType, Date createTime, Date updateTime) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
        this.productStatus = productStatus;
        this.categoryType = categoryType;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
