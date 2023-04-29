package com.ecommerce.order.api.utils;

import com.ecommerce.order.api.domain.valueobject.Product;
import com.ecommerce.order.api.infra.feign.dto.ProductResponse;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductFactory {

    public static Product createProduct() {
        return new Product(UUID.randomUUID(), "Product Test", BigDecimal.TEN);
    }

    public static ProductResponse createProductResponse() {
        return new ProductResponse(UUID.randomUUID(), "Product Test", BigDecimal.TEN);
    }
}
