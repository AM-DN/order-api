package com.ecommerce.order.api.infra.feign.impl;

import com.ecommerce.order.api.domain.valueobject.Product;
import com.ecommerce.order.api.infra.feign.ProductFeignClient;
import com.ecommerce.order.api.infra.feign.mapper.ProductMapper;
import com.ecommerce.order.api.utils.ProductFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class ProductDataProviderImplTest {

    private @Mock ProductFeignClient productFeignClient;

    private @Mock ProductMapper productMapper;

    @Test
    public void testGetByProductId() {
        Product product = ProductFactory.createProduct();
        Mockito.when(productMapper.toProductEntity(Mockito.any())).thenReturn(product);
        ProductDataProviderImpl productDataProvider = new ProductDataProviderImpl(productFeignClient, productMapper);
        Product getByProductId = productDataProvider.getByProductId(UUID.randomUUID());
        Assertions.assertEquals(product.productId(), getByProductId.productId());
        Assertions.assertEquals(product.price(), getByProductId.price());
    }
}
