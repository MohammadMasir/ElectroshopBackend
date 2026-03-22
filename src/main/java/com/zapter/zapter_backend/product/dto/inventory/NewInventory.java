package com.zapter.zapter_backend.product.dto.inventory;

public record NewInventory(
        Integer quantity,
        Integer minimumCount,
        Long productId,
        Long warehouseId,
        Long vendorId
)
{}
