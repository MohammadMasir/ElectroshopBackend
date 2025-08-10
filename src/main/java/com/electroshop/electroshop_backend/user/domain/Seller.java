package com.electroshop.electroshop_backend.user.domain;

import com.electroshop.electroshop_backend.product.domain.Category;
import com.electroshop.electroshop_backend.product.domain.Inventory;
import com.electroshop.electroshop_backend.product.domain.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@Table(name = "seller")
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "seller")
	private Set<Category> categories = new HashSet<>();
	
	@OneToMany(mappedBy = "inventorySeller")
	private List<Inventory> inventories = new ArrayList<>();
	
	@OneToMany(mappedBy = "productSeller")
	private List<Product> products = new ArrayList<>();
	
}
