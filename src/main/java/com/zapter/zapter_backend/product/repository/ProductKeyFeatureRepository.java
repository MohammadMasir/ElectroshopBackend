package com.zapter.zapter_backend.product.repository;

import com.zapter.zapter_backend.product.domain.ProductKeyFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductKeyFeatureRepository extends JpaRepository<ProductKeyFeature, Long> {

}
