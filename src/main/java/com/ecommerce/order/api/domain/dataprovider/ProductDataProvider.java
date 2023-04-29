package com.ecommerce.order.api.domain.dataprovider;

import com.ecommerce.order.api.domain.valueobject.Product;

import java.util.UUID;

public interface ProductDataProvider {

    Product getByProductId(UUID productId);

}
