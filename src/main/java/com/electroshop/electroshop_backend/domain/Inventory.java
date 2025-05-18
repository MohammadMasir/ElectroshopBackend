package com.electroshop.electroshop_backend.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id")
	private Product inventoryProduct;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(name = "first_batch", nullable = false)
	private LocalDateTime firstBatch;

	@Column(name = "last_batch", nullable = false)
	private LocalDateTime lastBatch;

	@Column(name = "min_count",nullable = false)
	private int minimumCount;
	
	
}
