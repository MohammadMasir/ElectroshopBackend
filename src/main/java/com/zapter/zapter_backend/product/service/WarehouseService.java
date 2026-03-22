package com.zapter.zapter_backend.product.service;

import com.zapter.zapter_backend.product.domain.Warehouse;
import com.zapter.zapter_backend.product.dto.warehouse.WarehouseResponse;
import com.zapter.zapter_backend.product.dto.warehouse.NewWarehouse;
import com.zapter.zapter_backend.product.mapper.WarehouseMapper;
import com.zapter.zapter_backend.product.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper warehouseMapper;

    public WarehouseService(
            WarehouseRepository warehouseRepository,
            WarehouseMapper warehouseMapper
            ){
        this.warehouseRepository = warehouseRepository;
        this.warehouseMapper = warehouseMapper;
    }

    public void createWarehouse(NewWarehouse newWarehouse){
        try {
            warehouseRepository.save(warehouseMapper.toWarehouse(newWarehouse));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Warehouse warehouse){
        warehouseRepository.save(warehouse);
    }

    public void delete(Long id){
        try {
            warehouseRepository.deleteById(id);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    public List<WarehouseResponse> get(){
        try {
            return warehouseMapper.toListOfWarehouseResponse(warehouseRepository.findAll());
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
    public WarehouseResponse getById(Long id){
        try {
            return warehouseMapper.toWarehouseResponse(warehouseRepository.findById(id).orElseThrow(RuntimeException::new));
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
}
