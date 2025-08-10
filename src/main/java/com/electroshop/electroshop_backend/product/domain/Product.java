package com.electroshop.electroshop_backend.product.domain;

import com.electroshop.electroshop_backend.cart.domain.CartProduct;
import com.electroshop.electroshop_backend.measurement.domain.ProductMeasurement;
import com.electroshop.electroshop_backend.order.domain.OrderProduct;
import com.electroshop.electroshop_backend.product.enums.StockStatus;
import com.electroshop.electroshop_backend.user.domain.Seller;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
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
	@JoinColumn(name = "seller_id")
	private Seller productSeller;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;

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
	
	@OneToMany(mappedBy = "products")
	private Set<CartProduct> cartProducts = new HashSet<>();
	
	@OneToMany(mappedBy = "products")
	private Set<OrderProduct> orders = new HashSet<>();
	
	@OneToMany(mappedBy = "detailsProduct")
	private List<ProductDetails> productDetails = new ArrayList<>();
		
	@OneToMany(mappedBy = "inventoryProduct")
	private List<Inventory> inventory = new ArrayList<>();
	
}
