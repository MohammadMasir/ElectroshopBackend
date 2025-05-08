package com.electroshop.electroshop_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electroshop.electroshop_backend.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
