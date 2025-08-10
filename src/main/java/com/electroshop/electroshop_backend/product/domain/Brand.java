package com.electroshop.electroshop_backend.product.domain;

import com.electroshop.electroshop_backend.product.domain.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@Table(name = "brands")
public class Brand{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "brand_name", nullable = false)
	private String brandName;
	
	@OneToMany(mappedBy = "brand")
	private List<Product> brandProduct;
	
	@OneToMany(mappedBy = "brandModel")
	private List<Model> model;
}
