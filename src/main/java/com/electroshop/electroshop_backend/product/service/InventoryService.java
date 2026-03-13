package com.electroshop.electroshop_backend.product.service;

import com.electroshop.electroshop_backend.product.domain.Inventory;
import com.electroshop.electroshop_backend.product.dto.inventory.InventoryResponse;
import com.electroshop.electroshop_backend.product.dto.inventory.NewInventory;
import com.electroshop.electroshop_backend.product.mapper.InventoryMapper;
import com.electroshop.electroshop_backend.product.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final InventoryMapper inventoryMapper;

    public InventoryService(
            InventoryRepository inventoryRepository,
            InventoryMapper inventoryMapper
    ){
        this.inventoryRepository = inventoryRepository;
        this.inventoryMapper = inventoryMapper;
    }

    public void createInventory(NewInventory newInventory){
        try {
            inventoryRepository.save(inventoryMapper.toInventory(newInventory));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Inventory inventory){
        inventoryRepository.save(inventory);
    }

    public void delete(Long id){
        try {
            inventoryRepository.deleteById(id);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    public List<InventoryResponse> get(){
        try {
            return inventoryMapper.toListOfInventoryResponse(inventoryRepository.findAll());
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
    public InventoryResponse getById(Long id){
        try {
            return inventoryMapper.toInventoryResponse(inventoryRepository.findById(id).orElseThrow(RuntimeException::new));
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
}
