package com.electroshop.electroshop_backend.cart.dto;

import com.electroshop.electroshop_backend.product.domain.Product;

import java.util.Set;

public record CartResponse(
		Long userId,
		Set<Product> product
		) {}
