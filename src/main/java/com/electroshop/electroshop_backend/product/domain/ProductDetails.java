package com.electroshop.electroshop_backend.product.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
