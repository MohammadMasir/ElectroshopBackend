package com.electroshop.electroshop_backend.dto.product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Optional;

public record ProductResponse(
		String name, // Product
		Optional<String> color, // Product
		String description, // Product
		BigDecimal price, // Product
		Optional<String> stockStatus, // Product
		HashMap<String, Double> dimensions, // Product
		String brand, // Brand
		String category, // Category
		HashMap<String, String> specification, // ProductDetails
		String review // Review
		) {}
