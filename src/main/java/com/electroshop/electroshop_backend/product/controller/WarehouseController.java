package com.electroshop.electroshop_backend.product.controller;

import com.electroshop.electroshop_backend.product.dto.warehouse.NewWarehouse;
import com.electroshop.electroshop_backend.product.service.WarehouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService){
        this.warehouseService = warehouseService;
    }

    @PreAuthorize("hasRole('SUPER_ADMIN','SYSTEM_ADMIN')")
    @PostMapping
    public ResponseEntity<?> newWarehouse(NewWarehouse newWarehouse){
        try {
            warehouseService.createWarehouse(newWarehouse);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasRole('SUPER_ADMIN','SYSTEM_ADMIN')")
    @GetMapping
    public ResponseEntity<?> getWarehouseDetail(){
        try {
            return new ResponseEntity<>(warehouseService.get(),HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasRole('SUPER_ADMIN','SYSTEM_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getWarehouseById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(warehouseService.getById(id),HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasRole('SUPER_ADMIN','SYSTEM_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWarehouseById(@PathVariable Long id){
        try {
            warehouseService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
}
