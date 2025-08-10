package com.electroshop.electroshop_backend.order.domain;

import com.electroshop.electroshop_backend.user.domain.User;
import com.electroshop.electroshop_backend.order.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User orderUser;
	
	@OneToMany(mappedBy = "orders")
	private Set<OrderProduct> orderProduct = new HashSet<>();
	
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
 