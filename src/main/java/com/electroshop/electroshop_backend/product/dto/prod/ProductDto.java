package com.electroshop.electroshop_backend.product.dto.prod;

import java.math.BigDecimal;

public record ProductDto(
        String name, // Product
        String color, // Product
        String description, // Product
        BigDecimal price, // Product
//        String stockStatus, // Product ignore=true for stockStatus
//        HashMap<String, Double> dimensions, // Product
//        Long measurement, // ProductMeaurement will have the prod_id since it's 1-M from Product entity.
        Long categoryId, //	 Category
        Long brandId, // Brand
        Long modelId // Model
//        HashMap<String, String> specification, // ProductDetails
//        Long specification, // ProductDetails will have the prod_id since it's 1-M from Product entity.
//        Integer quantity // Inventory | This field is stored in inventory no need to use it here.
) {}
