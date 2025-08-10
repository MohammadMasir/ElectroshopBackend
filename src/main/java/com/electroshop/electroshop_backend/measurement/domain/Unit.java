package com.electroshop.electroshop_backend.measurement.domain;

import com.electroshop.electroshop_backend.measurement.enums.MeasurementCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@Table(
		name = "unit",
		uniqueConstraints = {
				@UniqueConstraint(name = "uk_unit_category", columnNames = {"id", "measurement_category"}),
				@UniqueConstraint(name = "uk_unit_name_category", columnNames = {"name", "measurement_category"}),
				@UniqueConstraint(name = "uk_unit_symbol_category", columnNames = {"symbol","measurement_category"})
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
	
	@Column(name = "measurement_category", nullable = false)
	@Enumerated(EnumType.STRING)
	private MeasurementCategory measurementCategory;
	
	@Column(name = "conversion_factor", precision = 20, scale = 10, nullable = false)
	private BigDecimal conversionFactor;
	
	@Column(name = "is_base_unit", nullable = false)
	private Boolean isBaseUnit;
	
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;


}
