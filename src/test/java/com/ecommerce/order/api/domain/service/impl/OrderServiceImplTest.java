package com.ecommerce.order.api.domain.service.impl;

import com.ecommerce.order.api.domain.dataprovider.OrderDataProvider;
import com.ecommerce.order.api.domain.entity.Order;
import com.ecommerce.order.api.utils.OrderFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

    private @Mock OrderDataProvider orderDataProvider;

    @Test
    public void testCreateOrder() {
        Order order = OrderFactory.createOrder();
        Mockito.when(orderDataProvider.save(Mockito.any(Order.class))).thenReturn(order);
        OrderServiceImpl orderService = new OrderServiceImpl(orderDataProvider);
        Order savedOrder = orderService.create(order);
        Assertions.assertEquals(order.getOrderStatus(), savedOrder.getOrderStatus());
        Assertions.assertEquals(order.getOrderId(), savedOrder.getOrderId());
        Assertions.assertEquals(order.getProductId(), savedOrder.getProductId());
        Assertions.assertEquals(order.getQuantity(), savedOrder.getQuantity());
    }

}
