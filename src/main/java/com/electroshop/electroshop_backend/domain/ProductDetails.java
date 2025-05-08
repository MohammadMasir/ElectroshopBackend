package com.electroshop.electroshop_backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "product_details")
public class ProductDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long detailId;
	
	@NotNull
	@Column(name = "product_id",nullable = false)
	private Long productId; 
	
	@Column(name = "specification_name")
	private String specificationName;
	
	@Column(name = "specification_detail")
	private String specificationDetails;
	
	@Column(name = "dimension_unit")
	private double dimensionUnit;
	
	@Column(name = "dimension_value")
	private double dimensionValue;
	
}
