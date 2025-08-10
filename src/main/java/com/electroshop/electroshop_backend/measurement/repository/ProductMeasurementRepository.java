package com.electroshop.electroshop_backend.measurement.repository;

import com.electroshop.electroshop_backend.measurement.domain.ProductMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMeasurementRepository extends JpaRepository<ProductMeasurement, Long>{

}
