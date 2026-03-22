package com.zapter.zapter_backend.cart.repository;

import com.zapter.zapter_backend.cart.domain.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProduct, Long>{

}
