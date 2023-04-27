package com.ecommerce.order.api.application.controller.v1;

import com.ecommerce.order.api.application.dto.create.CreateOrderCommand;
import com.ecommerce.order.api.application.dto.create.CreateOrderResponse;
import com.ecommerce.order.api.application.mapper.OrderMapper;
import com.ecommerce.order.api.domain.entity.Order;
import com.ecommerce.order.api.domain.service.OrderService;
import com.ecommerce.order.api.utils.OrderFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {

    private @Mock OrderService orderService;
    private @Mock OrderMapper orderMapper;

    @Test
    public void testCreateOrder() {
        Order order = OrderFactory.createOrder();
        Mockito.when(orderService.create(Mockito.any(Order.class))).thenReturn(order);
        Mockito.when(orderMapper.toEntity(Mockito.any(CreateOrderCommand.class))).thenReturn(order);
        Mockito.when(orderMapper.toDto(Mockito.any(Order.class))).thenReturn(OrderFactory.createOrderResponse());
        OrderController orderController = new OrderController(orderService, orderMapper);
        CreateOrderResponse response = orderController.createOrder(OrderFactory.createOrderCommand()).getBody();
        Assertions.assertNotNull(response);
        Assertions.assertNotNull(response.orderId());
    }

}
