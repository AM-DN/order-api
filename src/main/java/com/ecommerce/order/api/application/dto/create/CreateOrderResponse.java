package com.ecommerce.order.api.application.dto.create;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateOrderResponse(@NotNull UUID orderId) {
}
