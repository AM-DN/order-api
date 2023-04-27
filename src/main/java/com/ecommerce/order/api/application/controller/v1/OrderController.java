package com.ecommerce.order.api.application.controller.v1;

import com.ecommerce.order.api.application.dto.create.CreateOrderCommand;
import com.ecommerce.order.api.application.dto.create.CreateOrderResponse;
import com.ecommerce.order.api.application.mapper.OrderMapper;
import com.ecommerce.order.api.domain.entity.Order;
import com.ecommerce.order.api.domain.service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/v1/order")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<CreateOrderResponse> createOrder(@Valid @RequestBody CreateOrderCommand createOrderCommand) {
        Order order = orderMapper.toEntity(createOrderCommand);
        Order orderCreated = orderService.create(order);
        return new ResponseEntity<>(orderMapper.toDto(orderCreated), HttpStatus.CREATED);
    }

}
