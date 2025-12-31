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
@Table(name = "order_product")
public class OrderProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product orderProduct;
	
	@ManyToOne
	@JoinColumn(name = "orders")
	private Order orders;
	
}
