package com.electroshop.electroshop_backend.dto;

import java.math.BigDecimal;
import java.util.Optional;

public record ProductResponse(
		String name,
		Optional<String> color,
		String description,
		String brand,
		String category,
		Optional<String> stockStatus,
		BigDecimal price
		) {}
