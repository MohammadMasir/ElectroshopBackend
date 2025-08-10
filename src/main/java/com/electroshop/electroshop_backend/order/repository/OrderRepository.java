package com.electroshop.electroshop_backend.order.repository;

import com.electroshop.electroshop_backend.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
