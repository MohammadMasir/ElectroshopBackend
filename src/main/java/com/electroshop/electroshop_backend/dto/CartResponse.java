package com.electroshop.electroshop_backend.dto;

import java.util.Set;

import com.electroshop.electroshop_backend.domain.Product;

public record CartResponse(
		Long userId,
		Set<Product> product
		) {}
