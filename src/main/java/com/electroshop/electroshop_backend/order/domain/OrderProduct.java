package com.electroshop.electroshop_backend.order.domain;

import com.electroshop.electroshop_backend.product.domain.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@Table(name = "order_product")
public class OrderProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "products")
	private Product products;
	
	@ManyToOne
	@JoinColumn(name = "orders")
	private Order orders;
	
}
