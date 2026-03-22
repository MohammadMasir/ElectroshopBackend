package com.zapter.zapter_backend.product.dto.prod;

import java.math.BigDecimal;

public record ProductAdd(
        String name, // Product
        String color, // Product
        String description, // Product
        BigDecimal price, // Product
        Long categoryId, //	 Category
        Long brandId, // Brand
        Long modelId // Model
) {}
