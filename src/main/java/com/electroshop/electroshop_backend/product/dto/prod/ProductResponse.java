package com.electroshop.electroshop_backend.product.dto.prod;

import com.electroshop.electroshop_backend.product.domain.Brand;
import com.electroshop.electroshop_backend.product.domain.Category;
import com.electroshop.electroshop_backend.product.domain.Review;

import java.math.BigDecimal;
import java.util.HashMap;

public record ProductResponse(
		String name, // Product
		String color, // Product
		String description, // Product
		BigDecimal price, // Product
		HashMap<String, Double> dimensions, // Product
		Brand brand, // Brand
		Category category, //	 Category
		HashMap<String, String> specification, // ProductDetails
		Review review // Review
		) {}
