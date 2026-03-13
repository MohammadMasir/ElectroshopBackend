package com.electroshop.electroshop_backend.product.domain;

import com.electroshop.electroshop_backend.user.domain.Vendor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product inventoryProduct;
	
	@Column(nullable = false)
	private Integer quantity;
	
	@Column(name = "first_batch", nullable = false)
	private LocalDateTime batchDate;

//	@ManyToOne
//	@JoinColumn(name = "seller_id", nullable = false)
//	private Seller inventorySeller;

	@Column(name = "min_count",nullable = false)
	private int minimumCount;

	@ManyToOne
	@JoinColumn(name = "warehouse_id", nullable = false)
	private Warehouse inventoryWarehouse;

	@ManyToOne
	@JoinColumn(name = "vendor_id", nullable = false)
	private Vendor inventoryVendor;

}
