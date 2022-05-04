package com.lightsoft.bestpractices.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("productD")
public class ProductFourServiceImpl implements ProductService {
    @Override
    public String orderingProduct() {
        log.info("order productD");
        return "成功订购产品D";
    }
}
