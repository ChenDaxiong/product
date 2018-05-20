package com.cx.controller;


import com.cx.DecreaseStockInput;
import com.cx.ProductInfoForOrder;
import com.cx.common.ServerResponse;
import com.cx.dataObject.ProductCategory;
import com.cx.dataObject.ProductInfo;
import com.cx.service.CategoryService;
import com.cx.service.ProductService;
import com.cx.vo.ProductInfoVo;
import com.cx.vo.ProductResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chenxiong on 18/5/8.
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     *
     */
    @GetMapping("/list")
    public ServerResponse list() {
        //查询所有在售的商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        List<Integer> categoryIds = new ArrayList<Integer>();
        //获取所有在售商品的类型列表
        Iterator it = productInfoList.iterator();
        while (it.hasNext()) {
            ProductInfo productInfo = (ProductInfo) it.next();
            if (!categoryIds.contains(productInfo.getCategoryType())) {
                categoryIds.add(productInfo.getCategoryType());
            }
        }

        //从数据库中查询类目
        List<ProductCategory> categoryList = categoryService.findByCategoryType(categoryIds);

        //构造数据
        List<ProductResultVo> productResultVoList = new ArrayList<>();
        for (ProductCategory productCategory : categoryList) {
            ProductResultVo productResultVo = new ProductResultVo();
            productResultVo.setCategoryName(productCategory.getCategoryName());
            productResultVo.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVo> productInfoVoList = new ArrayList<ProductInfoVo>();
            for (ProductInfo productInfo : productInfoList) {

                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    //如果类型相等，将其归为一类
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    //组成ProductInfoVo对象
                    BeanUtils.copyProperties(productInfo, productInfoVo);
                    productInfoVoList.add(productInfoVo);
                }
            }
            productResultVo.setProductInfoVoList(productInfoVoList);
            productResultVoList.add(productResultVo);
        }
        return ServerResponse.createBySuccess(productResultVoList);

    }

    /**
     * @param
     * @return 获取商品列表，供订单服务调用
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoForOrder> getProductList(@RequestBody List<String> productIdList) {
        List<ProductInfoForOrder> result = productService.findList(productIdList);
        return result;
    }

    /**
     * 扣库存操作
     *
     * @return
     * @RequestBody：将请求参数作json解析
     */
    @PostMapping("/decreaseStock")
    public void decrease(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
        productService.decreaseStock(decreaseStockInputList);

    }


}
