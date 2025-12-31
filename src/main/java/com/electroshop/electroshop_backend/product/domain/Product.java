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
@Table(name = "products")
public class Product{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	private String color;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StockStatus stockStatus;
	
	@Column(nullable = false)
	private BigDecimal price;

	@Column(name = "product_measurement_id")
	@OneToMany(mappedBy = "measurementProduct")
	private List<ProductMeasurement> productMeasurement = new ArrayList<>();

	@OneToMany(mappedBy = "prodFeature")
	private Set<ProductFeature> productKeyFeatures = new HashSet<>();

	@OneToMany(mappedBy = "cartProduct")
	private Set<CartProduct> cartProducts = new HashSet<>();

	@OneToMany(mappedBy = "orderProduct")
	private Set<OrderProduct> orders = new HashSet<>();

	@OneToMany(mappedBy = "reviewProduct")
	private List<Review> prodReview = new ArrayList<>() ;

	@OneToMany(mappedBy = "detailsProduct")
	private List<ProductDetails> productDetails = new ArrayList<>();
		
	@OneToMany(mappedBy = "inventoryProduct")
	private List<Inventory> inventory = new ArrayList<>();

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
}
