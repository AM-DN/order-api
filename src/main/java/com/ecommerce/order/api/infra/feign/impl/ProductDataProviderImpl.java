package com.ecommerce.order.api.infra.feign.impl;

import com.ecommerce.order.api.domain.dataprovider.ProductDataProvider;
import com.ecommerce.order.api.domain.valueobject.Product;
import com.ecommerce.order.api.infra.feign.ProductFeignClient;
import com.ecommerce.order.api.infra.feign.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductDataProviderImpl implements ProductDataProvider {

    private final ProductFeignClient productFeignClient;
    private final ProductMapper productMapper;

    @Override
    public Product getByProductId(UUID productId) {
        return productMapper.toProductEntity(productFeignClient.getByProductId(productId));
    }
}
