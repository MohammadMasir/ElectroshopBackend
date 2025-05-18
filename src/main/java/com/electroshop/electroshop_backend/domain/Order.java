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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product orderProduct;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User orderUser;
	
	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private Cart cart;
	
	@Column(columnDefinition = "varchar(255) default 'PENDING'", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(nullable = false)
	private BigDecimal amount;
	
}
 