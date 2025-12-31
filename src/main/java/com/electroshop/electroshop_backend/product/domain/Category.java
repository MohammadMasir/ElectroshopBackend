package com.electroshop.electroshop_backend.product.domain;

import com.electroshop.electroshop_backend.user.domain.SellerCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@OneToMany(mappedBy = "category") //TBR
	private List<Product> categoryProduct = new ArrayList<>();

	@OneToMany(mappedBy = "sellerCategory")
	private Set<SellerCategory> categorySeller = new HashSet<>();

}
