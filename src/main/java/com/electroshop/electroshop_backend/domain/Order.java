package com.electroshop.electroshop_backend.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.electroshop.electroshop_backend.enums.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User orderUser;
	
//	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//	@JoinTable(
//			name = "order_product",
//			joinColumns = 
//				@JoinColumn(name="order_id", referencedColumnName = "id"),
//			inverseJoinColumns = 
//				@JoinColumn(name = "product_id", referencedColumnName = "id" )
//			)
	@OneToMany(mappedBy = "productOrder")
	private Set<Product> orderProduct = new HashSet<>();
	
	@Column(columnDefinition = "varchar(255) default 'PENDING'", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(nullable = false)
	private BigDecimal amount;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private LocalDateTime dispatchDate;
	
	@Column(nullable = false)
	private LocalDateTime deliveryDate;
	
}
 