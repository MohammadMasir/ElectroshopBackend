package com.electroshop.electroshop_backend.domain;

import java.time.LocalDateTime;

import com.electroshop.electroshop_backend.enums.MeasurementCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Data
@Table(
		name = "measurement_types",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = {"id", "measurement_category"}),
				@UniqueConstraint(columnNames = {"name", "measurement_category"}) // This defines the composite unique constraint on both the columns simultaneously.
		}
		)
public class MeasurementType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(name = "measurement_category", nullable = false)
	private MeasurementCategory measurementCategory;
	
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	
	
	
}
