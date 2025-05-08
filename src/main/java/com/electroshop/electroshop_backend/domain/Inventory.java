package com.electroshop.electroshop_backend.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "inventory")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "product_id", nullable = false)
	private Long productId;
	
	@NotNull
	@Column(nullable = false)
	private int quantity;
	
	@NotNull
	@Column(name = "first_batch", nullable = false)
	private LocalDateTime firstBatch;

	@NotNull
	@Column(name = "last_batch", nullable = false)
	private LocalDateTime lastBatch;

	@NotNull
	@Column(name = "min_count",nullable = false)
	private int minimumCount;
	
	
}
