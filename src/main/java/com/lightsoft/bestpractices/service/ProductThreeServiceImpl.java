package com.lightsoft.bestpractices.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("productC")
@Scope(value = "prototype")
@Slf4j
public class ProductThreeServiceImpl implements ProductService {
    @Override
    public String orderingProduct() {
        log.info(" this.getClass().hashCode():{}, this.hashCode(): {}", this.getClass().hashCode(), this.hashCode());
        return "策略C";
    }
}
