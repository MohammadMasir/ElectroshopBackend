package com.electroshop.electroshop_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electroshop.electroshop_backend.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
