package com.electroshop.electroshop_backend.product.dto;

import java.math.BigDecimal;
import java.util.HashMap;

public record ProductResponse(
		String name, // Product
		String color, // Product
		String description, // Product
		BigDecimal price, // Product
		HashMap<String, Double> dimensions, // Product
		String brand, // Brand
		String category, //	 Category
		HashMap<String, String> specification, // ProductDetails
		String review // Review
		) {}
