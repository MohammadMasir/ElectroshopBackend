package com.electroshop.electroshop_backend.measurement.domain;

import com.electroshop.electroshop_backend.product.domain.Product;
import com.electroshop.electroshop_backend.measurement.domain.Unit;
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

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "measurement_type_id", referencedColumnName = "id", insertable = false, updatable = false),
		@JoinColumn(name = "measurement_category", referencedColumnName = "measurement_category", insertable = false, updatable = false),
				}
			)
	private MeasurementType measurementType;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "unit_id", referencedColumnName = "id", insertable = false, updatable = false),
		@JoinColumn(name = "measurement_category", referencedColumnName = "measurement_category", insertable = false, updatable = false)
				}
			)
	private Unit unit;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(nullable = false, precision = 15, scale = 6)
	private BigDecimal value;
	
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	
}
