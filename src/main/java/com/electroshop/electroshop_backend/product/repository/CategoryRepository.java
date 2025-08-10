package com.electroshop.electroshop_backend.product.repository;

import com.electroshop.electroshop_backend.product.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
