package com.ecommerce.order.api.domain.service.impl;

import com.ecommerce.order.api.domain.dataprovider.OrderDataProvider;
import com.ecommerce.order.api.domain.dataprovider.ProductDataProvider;
import com.ecommerce.order.api.domain.entity.Order;
import com.ecommerce.order.api.domain.service.OrderService;
import com.ecommerce.order.api.domain.valueobject.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private OrderDataProvider orderDataProvider;
    private ProductDataProvider productDataProvider;

    @Override
    public Order create(Order order) {
        Product product = productDataProvider.getByProductId(order.getProductId());
        order.initializeOrder(product.price());
        return orderDataProvider.save(order);
    }
}
