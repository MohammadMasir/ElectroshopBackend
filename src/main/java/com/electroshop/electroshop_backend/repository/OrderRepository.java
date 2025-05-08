package com.electroshop.electroshop_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electroshop.electroshop_backend.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
