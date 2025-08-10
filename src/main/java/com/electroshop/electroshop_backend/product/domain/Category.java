package com.electroshop.electroshop_backend.product.domain;

import com.electroshop.electroshop_backend.user.domain.Seller;
import com.electroshop.electroshop_backend.product.enums.Categories;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
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
