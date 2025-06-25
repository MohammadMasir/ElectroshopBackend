package com.electroshop.electroshop_backend.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Comment;

import com.electroshop.electroshop_backend.enums.MeasurementCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
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
