package com.ecommerce.order.api.domain.service;

import com.ecommerce.order.api.domain.entity.Order;

public interface OrderService {

    Order create(Order order);

}
