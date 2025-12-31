package com.electroshop.electroshop_backend.product.domain;

import com.electroshop.electroshop_backend.product.enums.Ratings;
import com.electroshop.electroshop_backend.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@Table(name = "review")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User reviewUser;

	@ManyToOne
	@JoinColumn(name = "prod_id", nullable = false)
	private Product reviewProduct;
	
	@Column(name = "rating", nullable = false)
	@Enumerated(EnumType.STRING)
	private Ratings rating;
	
	private String review;
	
}
