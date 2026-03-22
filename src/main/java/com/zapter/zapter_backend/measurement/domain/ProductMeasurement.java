package com.zapter.zapter_backend.measurement.domain;

import com.zapter.zapter_backend.product.domain.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(
		name = "product_measurements",
		uniqueConstraints =
		{
				@UniqueConstraint(columnNames = {"product_id", "measurement_type_id", "unit_id"}),
		}
		)
public class ProductMeasurement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@ManyToOne
//	@JoinColumns({
	@JoinColumn(name = "measurement_type_id", referencedColumnName = "id", updatable = false)
//		@JoinColumn(name = "measurement_category", referencedColumnName = "measurement_category", insertable = false, updatable = false),
//				}
//			)
	private MeasurementType measurementType;

	@ManyToOne
//	@JoinColumns({
	@JoinColumn(name = "unit_id", referencedColumnName = "id", updatable = false)
//		@JoinColumn(name = "measurement_category", referencedColumnName = "measurement_category", insertable = false, updatable = false)
//				}
//			)
	private Unit unit;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product measurementProduct;

	@Column(nullable = false, precision = 15, scale = 6)
	private BigDecimal value;

}
