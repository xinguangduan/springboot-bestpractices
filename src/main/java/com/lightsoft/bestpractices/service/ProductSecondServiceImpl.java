package com.lightsoft.bestpractices.service;

import org.springframework.stereotype.Service;

@Service("productB")
public class ProductSecondServiceImpl implements ProductService {

    @Override
    public String orderingProduct() {
        // 执行产品订购逻辑
        //....
        return "成功订购产品B";
    }

}