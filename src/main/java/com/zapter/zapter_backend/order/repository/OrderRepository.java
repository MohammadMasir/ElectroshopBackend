package com.zapter.zapter_backend.order.repository;

import com.zapter.zapter_backend.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
