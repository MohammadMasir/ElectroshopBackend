package com.electroshop.electroshop_backend.domain.embeddables;

import com.electroshop.electroshop_backend.enums.MeasurementCategory;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class MeasurementTypeId{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "measurement_category", nullable = false)
	private MeasurementCategory measurementCategory;
}
