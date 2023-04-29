package com.ecommerce.order.api.utils;

import com.ecommerce.order.api.application.dto.create.CreateOrderCommand;
import com.ecommerce.order.api.application.dto.create.CreateOrderResponse;
import com.ecommerce.order.api.domain.entity.Order;
import com.ecommerce.order.api.domain.entity.enums.OrderStatus;

import java.math.BigDecimal;
import java.util.UUID;

public final class OrderFactory {

    public static Order createOrder() {
        return Order.builder()
                .id(1L)
                .orderStatus(OrderStatus.PENDING)
                .orderId(UUID.randomUUID())
                .productId(UUID.randomUUID())
                .quantity(4)
                .build();
    }

    public static Order createOrderWithProductIdNull() {
        return Order.builder()
                .id(1L)
                .orderId(UUID.randomUUID())
                .productId(null)
                .orderStatus(OrderStatus.PENDING)
                .quantity(4)
                .price(BigDecimal.TEN)
                .build();
    }

    public static CreateOrderResponse createOrderResponse() {
        return new CreateOrderResponse(UUID.randomUUID());
    }

    public static CreateOrderCommand createOrderCommand() {
        return new CreateOrderCommand(UUID.randomUUID(), 4);
    }

}
