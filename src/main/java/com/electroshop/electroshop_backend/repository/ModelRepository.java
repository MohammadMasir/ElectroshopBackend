package com.electroshop.electroshop_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electroshop.electroshop_backend.domain.Model;

public interface ModelRepository extends JpaRepository<Model, Long>{

}
