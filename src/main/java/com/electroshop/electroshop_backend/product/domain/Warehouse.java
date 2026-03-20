package com.electroshop.electroshop_backend.product.domain;

import com.electroshop.electroshop_backend.user.domain.PickupAddress;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "warehouse_name")
    private String warehouseName;

    @Column(name = "warehouse_address")
    private String warehouseAddress;

    @OneToMany(mappedBy = "inventoryWarehouse")
    private List<Inventory> productInventory = new ArrayList<>();

    @OneToMany(mappedBy = "warehousePickupAddress")
    private List<PickupAddress> pickupAddresses = new ArrayList<>();

}
