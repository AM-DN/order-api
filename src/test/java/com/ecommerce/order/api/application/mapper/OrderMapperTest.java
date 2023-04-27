package com.ecommerce.order.api.application.mapper;

import com.ecommerce.order.api.application.dto.create.CreateOrderCommand;
import com.ecommerce.order.api.application.dto.create.CreateOrderResponse;
import com.ecommerce.order.api.domain.entity.Order;
import com.ecommerce.order.api.utils.OrderFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderMapperTest {

    private final OrderMapper orderMapper = new OrderMapper();

    @Test
    public void testToEntity() {
        CreateOrderCommand createOrderCommand = OrderFactory.createOrderCommand();
        Order entity = orderMapper.toEntity(createOrderCommand);
        Assertions.assertEquals(createOrderCommand.productId(), entity.getProductId());
        Assertions.assertEquals(createOrderCommand.quantity(), entity.getQuantity());
    }

    @Test
    public void testToDto() {
        Order order = OrderFactory.createOrder();
        CreateOrderResponse createOrderResponse = orderMapper.toDto(order);
        Assertions.assertEquals(order.getOrderId(), createOrderResponse.orderId());
    }

}
