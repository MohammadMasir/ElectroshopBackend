package com.electroshop.electroshop_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electroshop.electroshop_backend.domain.CartProduct;

public interface CartProductRepository extends JpaRepository<CartProduct, Long>{

}
