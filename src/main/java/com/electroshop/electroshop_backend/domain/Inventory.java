package com.electroshop.electroshop_backend.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product inventoryProduct;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(name = "first_batch", nullable = false)
	private LocalDateTime batchDate;

	@ManyToOne
	@JoinColumn(name = "seller_id", nullable = false)
	private Seller seller;

	@Column(name = "min_count",nullable = false)
	private int minimumCount;
	
	
}
