package com.electroshop.electroshop_backend.product.repository;

import com.electroshop.electroshop_backend.product.domain.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {

}
