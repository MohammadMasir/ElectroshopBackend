package com.electroshop.electroshop_backend.measurement.domain;

import com.electroshop.electroshop_backend.measurement.enums.MeasurementCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@Table(
		name = "measurement_types",
		uniqueConstraints = {
				@UniqueConstraint(name = "uk_measurement_type_category", columnNames = {"id", "measurement_category"}),
				@UniqueConstraint(name = "uk_measurement_name_category", columnNames = {"name", "measurement_category"}) // This defines the composite unique constraint on both the columns simultaneously.
		}
		)
public class MeasurementType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(name = "measurement_category", nullable = false)
	@Enumerated(EnumType.STRING)
	private MeasurementCategory measurementCategory;
	
	@Column(nullable = false)
	private String description;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	
}
