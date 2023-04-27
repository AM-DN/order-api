package com.ecommerce.order.api.domain.entity;

import com.ecommerce.order.api.utils.OrderFactory;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals(1, constraintViolations.size());
    }

}
