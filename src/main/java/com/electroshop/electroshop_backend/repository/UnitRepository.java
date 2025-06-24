package com.electroshop.electroshop_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electroshop.electroshop_backend.domain.Brand;
import com.electroshop.electroshop_backend.domain.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long>{

}
