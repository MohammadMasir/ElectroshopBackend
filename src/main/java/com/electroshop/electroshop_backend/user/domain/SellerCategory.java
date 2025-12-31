package com.electroshop.electroshop_backend.user.domain;

import com.electroshop.electroshop_backend.product.domain.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "SellerCategory")
public class SellerCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller categorySeller;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category sellerCategory;

}
