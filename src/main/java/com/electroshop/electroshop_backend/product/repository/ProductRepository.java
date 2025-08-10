package com.electroshop.electroshop_backend.product.repository;

import com.electroshop.electroshop_backend.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
