package com.electroshop.electroshop_backend.domain;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cart")
public class Cart{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id" ,nullable = false)
	private User cartUser;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "cart_product",
			joinColumns = 
				@JoinColumn(name="cart_id", referencedColumnName = "id"),
			inverseJoinColumns = 
				@JoinColumn(name = "product_id", referencedColumnName = "id" )
			)
	private Set<Product> products;
	
	@OneToMany(mappedBy = "cart")
	private List<Order> orders;
	
}
