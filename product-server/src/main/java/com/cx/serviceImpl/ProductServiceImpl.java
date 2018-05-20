package com.cx.serviceImpl;

import com.cx.DecreaseStockInput;
import com.cx.ProductInfoForOrder;
import com.cx.common.ProductExceptionEnum;
import com.cx.common.ProductStatus;
import com.cx.dataObject.ProductInfo;
import com.cx.exception.ProductException;
import com.cx.repository.ProductInfoRepository;
import com.cx.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxiong on 18/5/8.
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;


    /*
    * 查询所有在售的商品
    */
    @Override
    public List<ProductInfo> findUpAll() {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(ProductStatus.UP.getCode());
        return productInfoList;
    }

    /**
     * 根据商品的ID集合查找商品
     *
     * @param productIds
     * @return
     */
    @Override
    public List<ProductInfoForOrder> findList(List<String> productIds) {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductIdIn(productIds);
        List<ProductInfoForOrder> result = new ArrayList<ProductInfoForOrder>();
        if (!CollectionUtils.isEmpty(productInfoList)) {
            log.info("商品不存在");
            return result;
        }
        for (ProductInfo productInfo : productInfoList) {
            ProductInfoForOrder productInfoForOrder = new ProductInfoForOrder();
            BeanUtils.copyProperties(productInfo, productInfoForOrder);
            result.add(productInfoForOrder);
        }
        return result;

    }


    /**
     * @param decreaseStockInputList
     * @return 因为是对购物车里所有的商品进行减库存操作，保证整个过程是一个事务，加@Transactional注解
     */
    @Override
    @Transactional
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        for (DecreaseStockInput decreaseStockInput : decreaseStockInputList) {
            ProductInfo productInfo = productInfoRepository.findOne(decreaseStockInput.getProductId());
            if (productInfo == null) {
                log.info("选择的商品不存在，productInfo: {}", productInfo);
                //抛出自定义异常
                throw new ProductException(ProductExceptionEnum.PRODUCT_NOT_EXIST);
            } else if (productInfo.getProductStock() < decreaseStockInput.getProductQuantity()) {
                log.error("商品库存不足，productInfo：{}", productInfo);
                throw new ProductException(ProductExceptionEnum.PRODUCT_STOCK_NOTENOUGH);
            }
            //进行减库存的操作
            productInfo.setProductStock(productInfo.getProductStock() - decreaseStockInput.getProductQuantity());
            productInfoRepository.save(productInfo);
        }
    }
}
