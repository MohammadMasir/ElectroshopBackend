package com.electroshop.electroshop_backend.product.dto.category;

import jakarta.validation.constraints.NotBlank;

public record NewCategory(
        @NotBlank(message = "Category name cannot be empty!")
        String name
) { }
