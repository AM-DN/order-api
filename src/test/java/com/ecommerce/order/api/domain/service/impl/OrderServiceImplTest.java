package com.ecommerce.order.api.domain.service.impl;

import com.ecommerce.order.api.domain.dataprovider.OrderDataProvider;
import com.ecommerce.order.api.domain.dataprovider.ProductDataProvider;
import com.ecommerce.order.api.domain.entity.Order;
import com.ecommerce.order.api.domain.valueobject.Product;
import com.ecommerce.order.api.utils.OrderFactory;
import com.ecommerce.order.api.utils.ProductFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

    private @Mock OrderDataProvider orderDataProvider;
    private @Mock ProductDataProvider productDataProvider;

    @Test
    public void testCreateOrder() {
        Order order = OrderFactory.createOrder();
        Product product = ProductFactory.createProduct();
        Mockito.when(orderDataProvider.save(Mockito.any(Order.class))).thenReturn(order);
        Mockito.when(productDataProvider.getByProductId(Mockito.any(UUID.class))).thenReturn(product);
        OrderServiceImpl orderService = new OrderServiceImpl(orderDataProvider, productDataProvider);
        Order savedOrder = orderService.create(order);
        Assertions.assertEquals(order.getOrderStatus(), savedOrder.getOrderStatus());
        Assertions.assertEquals(order.getOrderId(), savedOrder.getOrderId());
        Assertions.assertEquals(order.getProductId(), savedOrder.getProductId());
        Assertions.assertEquals(order.getQuantity(), savedOrder.getQuantity());
        Assertions.assertEquals(order.getPrice(), product.price());
    }

}
