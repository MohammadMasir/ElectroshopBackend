package com.zapter.zapter_backend.measurement.repository;

import com.zapter.zapter_backend.measurement.domain.ProductMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMeasurementRepository extends JpaRepository<ProductMeasurement, Long>{

}
