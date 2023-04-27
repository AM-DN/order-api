package com.ecommerce.order.api.domain.dataprovider;

import com.ecommerce.order.api.domain.entity.Order;

public interface OrderDataProvider {

    Order save(Order order);

}
