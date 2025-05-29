package com.electroshop.electroshop_backend.dto.cart;

import java.util.Set;

import com.electroshop.electroshop_backend.domain.Product;

public record CartResponse(
		Long userId,
		Set<Product> product
		) {}
