package com.electroshop.electroshop_backend.product.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@RequiredArgsConstructor
@Table(name = "model")
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "brand_id", nullable = false)
	private Brand brandModel;
	
	@OneToMany(mappedBy = "model")
	private List<Product> products = new ArrayList<>();
	
}
