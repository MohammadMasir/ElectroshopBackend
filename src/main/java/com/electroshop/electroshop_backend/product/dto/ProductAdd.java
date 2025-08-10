package com.electroshop.electroshop_backend.product.dto;

import java.math.BigDecimal;
import java.util.HashMap;

public record ProductAdd(
        String name, // Product
        String color, // Product
        String description, // Product
        BigDecimal price, // Product
        String stockStatus, // Product
        HashMap<String, Double> dimensions, // Product
        String brand, // Brand
        String category, //	 Category
        HashMap<String, String> specification, // ProductDetails
        String review // Review
) {}
