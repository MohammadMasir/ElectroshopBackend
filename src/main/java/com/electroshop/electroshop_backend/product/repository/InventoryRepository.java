package com.electroshop.electroshop_backend.product.repository;

import com.electroshop.electroshop_backend.product.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}
