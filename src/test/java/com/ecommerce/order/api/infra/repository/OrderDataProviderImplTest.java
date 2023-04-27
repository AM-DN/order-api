package com.ecommerce.order.api.infra.repository;

import com.ecommerce.order.api.domain.entity.Order;
import com.ecommerce.order.api.infra.repository.impl.OrderDataProviderImpl;
import com.ecommerce.order.api.utils.OrderFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OrderDataProviderImplTest {

    private @Mock OrderRepository orderRepository;

    @Test
    public void testCreateOrder() {
        Order order = OrderFactory.createOrder();
        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(order);
        OrderDataProviderImpl orderDataProvider = new OrderDataProviderImpl(orderRepository);
        Order savedOrder = orderDataProvider.save(order);
        Assertions.assertEquals(order.getId(), savedOrder.getId());
        Assertions.assertEquals(order.getOrderStatus(), savedOrder.getOrderStatus());
        Assertions.assertEquals(order.getOrderId(), savedOrder.getOrderId());
        Assertions.assertEquals(order.getProductId(), savedOrder.getProductId());
        Assertions.assertEquals(order.getQuantity(), savedOrder.getQuantity());
    }

}
