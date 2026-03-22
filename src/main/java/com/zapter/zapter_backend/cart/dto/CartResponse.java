package com.zapter.zapter_backend.cart.dto;

import com.zapter.zapter_backend.product.domain.Product;

import java.util.Set;

public record CartResponse(
		Long userId,
		Set<Product> product
		) {}
