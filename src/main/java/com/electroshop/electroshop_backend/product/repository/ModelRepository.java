package com.electroshop.electroshop_backend.product.repository;

import com.electroshop.electroshop_backend.product.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long>{

}
