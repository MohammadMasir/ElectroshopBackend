package com.electroshop.electroshop_backend.dto.order;

import java.math.BigDecimal;
import java.util.Set;

import com.electroshop.electroshop_backend.domain.Product;
import com.electroshop.electroshop_backend.enums.Status;

public record OrderResponse(
		Long orderId,
		Set<Product> product,
		Status status,
		BigDecimal amount
		) {}
