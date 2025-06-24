package com.electroshop.electroshop_backend.domain;

import java.util.HashSet;
import java.util.Set;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private Categories name;
	
	@OneToMany(mappedBy = "category")
	private Set<Product> categoryProduct = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "seller_id")
	private Seller seller;
	
}
