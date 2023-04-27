package com.ecommerce.order.api.infra.repository.impl;

import com.ecommerce.order.api.domain.dataprovider.OrderDataProvider;
import com.ecommerce.order.api.domain.entity.Order;
import com.ecommerce.order.api.infra.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderDataProviderImpl implements OrderDataProvider {

    private final OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
