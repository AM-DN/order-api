package com.ecommerce.order.api.domain.service.impl;

import com.ecommerce.order.api.domain.dataprovider.OrderDataProvider;
import com.ecommerce.order.api.domain.entity.Order;
import com.ecommerce.order.api.domain.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private OrderDataProvider orderDataProvider;

    @Override
    public Order create(Order order) {
        return orderDataProvider.save(order);
    }
}
