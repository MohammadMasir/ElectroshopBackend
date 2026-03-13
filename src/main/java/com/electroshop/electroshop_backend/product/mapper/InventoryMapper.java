package com.electroshop.electroshop_backend.product.mapper;

import com.electroshop.electroshop_backend.product.domain.Inventory;
import com.electroshop.electroshop_backend.product.dto.inventory.InventoryResponse;
import com.electroshop.electroshop_backend.product.dto.inventory.NewInventory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InventoryMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Inventory toInventory(NewInventory newInventory);

    List<InventoryResponse> toListOfInventoryResponse(List<Inventory> inventory);

    InventoryResponse toInventoryResponse(Inventory inventory);
}
