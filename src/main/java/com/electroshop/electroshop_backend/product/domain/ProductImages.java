package com.electroshop.electroshop_backend.product.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ProductImages")
public class ProductImages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "product_id", nullable = false)
//    private Product product;

    @Lob // Indicates a large object, suitable for binary data
    @Column(name = "image_data", nullable = false)
    private byte[] imageData;

}
