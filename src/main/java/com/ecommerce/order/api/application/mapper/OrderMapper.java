package com.ecommerce.order.api.application.mapper;

import com.ecommerce.order.api.application.dto.create.CreateOrderCommand;
import com.ecommerce.order.api.application.dto.create.CreateOrderResponse;
import com.ecommerce.order.api.domain.entity.Order;
import com.ecommerce.order.api.domain.entity.enums.OrderStatus;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderMapper {

    public Order toEntity(CreateOrderCommand createOrderCommand) {
        return Order.builder()
                .orderId(UUID.randomUUID())
                .productId(createOrderCommand.productId())
                .quantity(createOrderCommand.quantity())
                .orderStatus(OrderStatus.PENDING)
                .build();
    }

    public CreateOrderResponse toDto(Order order) {
        return new CreateOrderResponse(order.getOrderId());
    }

}
