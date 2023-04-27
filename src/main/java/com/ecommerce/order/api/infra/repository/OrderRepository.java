package com.ecommerce.order.api.infra.repository;

import com.ecommerce.order.api.domain.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
