package com.ecommerce.order.api.domain.entity;

import com.ecommerce.order.api.domain.entity.enums.OrderStatus;
import com.ecommerce.order.api.domain.valueobject.Money;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Getter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private UUID orderId;

    @NotNull
    private UUID productId;

    @NotNull
    private Integer quantity;

    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;

    @NotNull
    private BigDecimal totalOrder;

    public void initializeOrder(BigDecimal price) {
        this.orderId = UUID.randomUUID();
        this.orderStatus = OrderStatus.PENDING;
        this.price = price;
        setTotalOrder();
    }

    private void setTotalOrder() {
        Money money = new Money(this.price);
        Money multiply = money.multiply(this.quantity);
        this.totalOrder = multiply.getAmount();
    }

}
