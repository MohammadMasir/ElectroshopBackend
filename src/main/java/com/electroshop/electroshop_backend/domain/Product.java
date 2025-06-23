package com.electroshop.electroshop_backend.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import com.electroshop.electroshop_backend.enums.StockStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
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
@Table(name = "products")
public class Product{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User productUser;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@ManyToOne
	@JoinColumn(name = "product_measurement_id")
	private ProductMeasurement productMeasurement;
	
	private String description;
	
	private String color;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StockStatus stockStatus;
	
	@Column(nullable = false)
	private BigDecimal price;
	
//	@Column(name = "dimension_unit")
//	private String dimensionUnit;
//	
//	@Column(name = "dimension_value")
//	private double dimensionValue;
	
	@ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
	private Set<Cart> carts;
	
	@ManyToMany(mappedBy = "orderProduct", fetch = FetchType.LAZY)
	private Set<Order> orders;
	
//	@OneToMany(mappedBy = "detailsProduct")
//	private List<ProductDetails> productDetails;
		
	@OneToMany(mappedBy = "inventoryProduct")
	private List<Inventory> inventory;
	
}
