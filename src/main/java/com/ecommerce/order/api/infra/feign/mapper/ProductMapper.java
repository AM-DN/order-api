package com.ecommerce.order.api.infra.feign.mapper;

import com.ecommerce.order.api.domain.valueobject.Product;
import com.ecommerce.order.api.infra.feign.dto.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toProductEntity(ProductResponse productResponse) {
        return new Product(productResponse.productId(), productResponse.name(), productResponse.price());
    }

}
