package com.electroshop.electroshop_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electroshop.electroshop_backend.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
