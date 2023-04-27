package com.ecommerce.order.api.application.dto.create;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateOrderCommand(@NotNull(message = "productId must be informed") UUID productId, @NotNull(message = "quantity must be informed") Integer quantity) {

}
