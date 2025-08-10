package com.electroshop.electroshop_backend.cart.domain;

import com.electroshop.electroshop_backend.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@Table(name = "carts")
public class Cart{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id" ,nullable = false)
	private User cartUser;
	
	@OneToMany(mappedBy = "carts")
	private Set<CartProduct> cartProducts = new HashSet<>();
	
}
