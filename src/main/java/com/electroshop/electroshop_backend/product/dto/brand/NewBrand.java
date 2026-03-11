package com.electroshop.electroshop_backend.product.dto.brand;

import jakarta.validation.constraints.NotBlank;

public record NewBrand(
        @NotBlank(message = "Brand name cannot be empty!")
        String name
) { }
