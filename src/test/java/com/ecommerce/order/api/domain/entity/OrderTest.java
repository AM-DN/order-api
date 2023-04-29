package com.ecommerce.order.api.domain.entity;

import com.ecommerce.order.api.utils.OrderFactory;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;

public class OrderTest {

    private static Validator validator;
    @BeforeAll
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testWithProductIdNull() {
        Set<ConstraintViolation<Order>> constraintViolations = validator.validate(OrderFactory.createOrderWithProductIdNull());
        Assertions.assertEquals(2, constraintViolations.size());
    }

    @Test
    public void testCalculateTotalOrder() {
        Order order = OrderFactory.createOrder();
        order.initializeOrder(new BigDecimal("10.34"));
        Assertions.assertEquals(new BigDecimal("41.36"), order.getTotalOrder());

        order.initializeOrder(new BigDecimal("11.113212312"));
        Assertions.assertEquals(new BigDecimal("44.45"), order.getTotalOrder());

        order.initializeOrder(new BigDecimal("10.444444"));
        Assertions.assertEquals(new BigDecimal("41.78"), order.getTotalOrder());

        order.initializeOrder(new BigDecimal("10.111111"));
        Assertions.assertEquals(new BigDecimal("40.44"), order.getTotalOrder());
    }

}
