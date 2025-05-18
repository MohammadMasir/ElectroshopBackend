package com.electroshop.electroshop_backend.dto;

import java.io.ObjectInputFilter.Status;
import java.math.BigDecimal;
import java.util.Set;

import com.electroshop.electroshop_backend.domain.Product;

public record OrderResponse(
		Long orderId,
		Set<Product> product,
		Status status,
		BigDecimal amount
		) {}
