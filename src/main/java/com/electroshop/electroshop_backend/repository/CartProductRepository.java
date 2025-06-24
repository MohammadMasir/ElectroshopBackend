package com.electroshop.electroshop_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electroshop.electroshop_backend.domain.Brand;

public interface CartProductRepository extends JpaRepository<CartProductRepository, Long>{

}
