package com.zapter.zapter_backend.cart.repository;

import com.zapter.zapter_backend.cart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
