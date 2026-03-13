package com.electroshop.electroshop_backend.user.domain;

import com.electroshop.electroshop_backend.product.domain.Inventory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vendor")
@Getter
@Setter
@NoArgsConstructor
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorId;

    @Column(name = "vendor_name")
    private String vendorName;

    @Column(name = "vendor_address")
    private String vendorAddress;

    @OneToMany(mappedBy = "inventoryVendor")
    private List<Inventory> vendorProducts = new ArrayList<>();

}
