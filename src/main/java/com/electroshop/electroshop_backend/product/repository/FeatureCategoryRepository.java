package com.electroshop.electroshop_backend.product.repository;

import com.electroshop.electroshop_backend.product.domain.FeatureCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureCategoryRepository extends JpaRepository<FeatureCategory, Long> {

}
