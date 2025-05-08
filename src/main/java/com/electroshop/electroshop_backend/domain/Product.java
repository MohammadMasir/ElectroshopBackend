package com.electroshop.electroshop_backend.domain;

import java.math.BigDecimal;
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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(nullable = false)
	private String name;
	
	@NotNull
	@Column(nullable = false)
	private Long categryId;
	
	@NotNull
	@Column(nullable = false)
	private Long brandId;

	private String description;
	
	private String color;
	
	@NotNull
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StockStatus stockStatus;
	
	@NotNull
	@Column(nullable = false)
	private BigDecimal price;
	
	@ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
	private Set<Cart> carts;
	
}
