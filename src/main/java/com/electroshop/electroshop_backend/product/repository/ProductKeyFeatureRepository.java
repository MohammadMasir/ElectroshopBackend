package com.electroshop.electroshop_backend.product.repository;

import com.electroshop.electroshop_backend.product.domain.ProductKeyFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductKeyFeatureRepository extends JpaRepository<ProductKeyFeature, Long> {

}
