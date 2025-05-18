package com.electroshop.electroshop_backend.dto;

import java.io.ObjectInputFilter.Status;
import java.math.BigDecimal;

public record OrderResponse(
		Long orderId,
		String productName,
		Status status,
		BigDecimal amount
		) {}
