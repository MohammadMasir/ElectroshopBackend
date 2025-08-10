package com.electroshop.electroshop_backend.cart.repository;

import com.electroshop.electroshop_backend.cart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
