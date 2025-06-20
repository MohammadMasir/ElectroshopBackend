package com.electroshop.electroshop_backend.domain;

import java.util.List;

import com.electroshop.electroshop_backend.enums.Categories;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private Categories name;
	
	@OneToMany(mappedBy = "category")
	private List<Product> categoryProduct;
	
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private Seller seller;
	
}
