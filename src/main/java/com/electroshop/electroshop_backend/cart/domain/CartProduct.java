package com.electroshop.electroshop_backend.cart.domain;

import com.electroshop.electroshop_backend.product.domain.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart_product")
public class CartProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart carts;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product products;
}
