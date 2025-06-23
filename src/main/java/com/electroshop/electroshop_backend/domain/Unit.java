package com.electroshop.electroshop_backend.domain;

import java.math.BigDecimal;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(
		name = "unit",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = {"id", "category"}),
				@UniqueConstraint(columnNames = {"name", "category"}),
				@UniqueConstraint(columnNames = {"symbol","category"})
			}
		)
public class Unit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String symbol;
	
	@Column(nullable = false)
	private MeasurementCategory category;
	
	@Column(name = "conversion_factor", precision = 20, scale = 10, nullable = false)
	private BigDecimal conversionFactor;
	
	@Column(name = "is_base_unit", nullable = false)
	private Boolean isBaseUnit;
	
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;


}
