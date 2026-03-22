package com.zapter.zapter_backend.product.repository;

import com.zapter.zapter_backend.product.domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{

}
