package com.zapter.zapter_backend.product.dto.prod;

import com.zapter.zapter_backend.product.domain.Brand;
import com.zapter.zapter_backend.product.domain.Category;
import com.zapter.zapter_backend.product.domain.Model;

import java.math.BigDecimal;

public record ProductResponse(
   String name,
   Category category,
   Brand brand,
   Model model,
   String color,
   String description,
   BigDecimal price
) {}
