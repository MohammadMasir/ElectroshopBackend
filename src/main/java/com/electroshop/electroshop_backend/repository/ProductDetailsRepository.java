package com.electroshop.electroshop_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electroshop.electroshop_backend.domain.ProductDetails;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {

}
