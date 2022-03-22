package com.lightsoft.bestpractices.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("productB")
@Slf4j
public class ProductSecondServiceImpl implements ProductService {

    @Override
    public String orderingProduct() {
        // 执行产品订购逻辑
        log.info("product a");
        return "成功订购产品B";
    }

}