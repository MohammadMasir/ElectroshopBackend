package com.electroshop.electroshop_backend.product.domain;

import com.electroshop.electroshop_backend.user.domain.PickupAddress;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long warehouseId;

    @Column(name = "warehouse_address")
    private String warehouseAddress;

    @OneToMany(mappedBy = "inventoryWarehouse")
    private List<Inventory> productInventory = new ArrayList<>();

    @OneToMany(mappedBy = "warehousePickupAddress")
    private List<PickupAddress> pickupAddresses = new ArrayList<>();

}
