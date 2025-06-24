package com.electroshop.electroshop_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electroshop.electroshop_backend.domain.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long>{

}
