package com.zapter.zapter_backend.product.repository;

import com.zapter.zapter_backend.product.domain.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {

}
