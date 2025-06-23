package com.electroshop.electroshop_backend.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import com.electroshop.electroshop_backend.enums.MeasurementCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
		name = "product_measurements",
		uniqueConstraints =
		{
				@UniqueConstraint(columnNames = {"product_id"}),
				@UniqueConstraint(columnNames = {"measurement_type_id"}),
				@UniqueConstraint(columnNames = {"unit_id"})
		}
		)
public class ProductMeasurement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "product_id", nullable = false)
	@OneToMany(mappedBy = "productMeasurement")
	private Set<Product> products;
	
	@Column(name = "measurment_type_id", nullable = false)
	@OneToMany(mappedBy = "measurmentType")
	private Set<MeasurementType> measurementTypes;
	
	@Column(name = "measurement_category_id", nullable = false)
	@OneToMany(mappedBy = "measurementCategory")
	private Set<MeasurementCategory> measurementCategories;

	@Column(name = "unit_id", nullable = false)
	@OneToMany(mappedBy = "unit")
	private Set<Unit> units;
	
	@Column(nullable = false, precision = 15, scale = 6)
	private BigDecimal value;
	
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	
}
