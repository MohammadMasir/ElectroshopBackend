package com.electroshop.electroshop_backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "product_details")
public class ProductDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "product_id",nullable = false)
	private Product detailsProduct; 
	
	@Column(name = "specification_name")
	private String specificationName;
	
	@Column(name = "specification_detail")
	private String specificationDetails;
	
}
