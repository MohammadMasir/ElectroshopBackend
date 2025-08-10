package com.electroshop.electroshop_backend.order.dto;

import com.electroshop.electroshop_backend.product.domain.Product;
import com.electroshop.electroshop_backend.order.enums.Status;

import java.math.BigDecimal;
import java.util.Set;

public record OrderResponse(
		Long orderId,
		Set<Product> product,
		Status status,
		BigDecimal amount
		) {}
