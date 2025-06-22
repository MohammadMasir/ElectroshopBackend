package com.electroshop.electroshop_backend.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.electroshop.electroshop_backend.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String address;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "cartUser")
	private List<Cart> carts;
	
	@OneToMany(mappedBy = "orderUser")
	private List<Order> userOrder;
	
	@OneToMany(mappedBy = "reviewUser")
	private List<Review> useReview;
	
	@OneToMany(mappedBy = "productUser")
	private List<Product> userProduct;
	
}
