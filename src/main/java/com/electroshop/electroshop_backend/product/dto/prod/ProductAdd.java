package com.electroshop.electroshop_backend.product.dto.prod;

import java.math.BigDecimal;
import java.util.HashMap;

public record ProductAdd(
        String name, // Product
        String color, // Product
        String description, // Product
        BigDecimal price, // Product
        String stockStatus, // Product
        HashMap<String, Double> dimensions, // Product
        String brandId, // Brand
        String categoryId, //	 Category
        String modelId, // Model
        HashMap<String, String> specification, // ProductDetails
        Integer quantity // Inventory
) {}
