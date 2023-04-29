package com.ecommerce.order.api.domain.valueobject;

import java.math.BigDecimal;
import java.util.UUID;

public record Product(

        UUID productId,

        String name,

        BigDecimal price
) {
}
