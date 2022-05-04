package com.lightsoft.bestpractices.rest;

import com.lightsoft.bestpractices.service.ProductService;
import com.lightsoft.bestpractices.service.ProductStrategyFactory;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProductController {

    @Resource
    private ProductStrategyFactory factoryForStrategy;

    /**
     * 执行下单订购产品
     *
     * @param type 产品类型(策略)
     * @return 订购结果
     */
    @PostMapping("/order")
    public String order(@RequestParam(value = "type") String type) {
        ProductService productService = factoryForStrategy.getProductStrategy(type);
        final String product = productService != null ? productService.orderingProduct() : "没有发现对应的产品处理策略";
        log.info(product);
        return product;
    }

}