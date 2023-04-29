package com.ecommerce.order.api.infra.feign.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponse(

        @NotNull UUID productId,

        @NotNull String name,

        @NotNull BigDecimal price

) {
}
