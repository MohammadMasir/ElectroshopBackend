package com.electroshop.electroshop_backend.domain;

import java.math.BigDecimal;

import com.electroshop.electroshop_backend.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "product_id", nullable = false)
	private Long productId;
	
	@NotNull
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	@NotNull
	@Column(name = "cart_id", nullable = false)
	private Long cartId;
	
	@NotNull
	@Column(columnDefinition = "varchar(255) default 'PENDING'", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@NotNull
	@Column(nullable = false)
	private BigDecimal amount;
	
}
 