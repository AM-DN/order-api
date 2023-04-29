package com.ecommerce.order.api.infra.feign.mapper;

import com.ecommerce.order.api.domain.valueobject.Product;
import com.ecommerce.order.api.infra.feign.dto.ProductResponse;
import com.ecommerce.order.api.utils.ProductFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductMapperTest {

    private final ProductMapper productMapper = new ProductMapper();

    @Test
    public void testToEntity() {
        ProductResponse productResponse = ProductFactory.createProductResponse();
        Product entity = productMapper.toProductEntity(productResponse);
        Assertions.assertEquals(productResponse.productId(), entity.productId());
        Assertions.assertEquals(productResponse.price(), entity.price());
    }

}
