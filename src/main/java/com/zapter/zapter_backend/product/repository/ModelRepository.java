package com.zapter.zapter_backend.product.repository;

import com.zapter.zapter_backend.product.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long>{

}
