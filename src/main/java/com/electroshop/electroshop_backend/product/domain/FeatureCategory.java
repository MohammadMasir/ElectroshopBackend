package com.electroshop.electroshop_backend.product.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "FeatureCategory")
public class FeatureCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "feature_id")
    private KeyFeatures keyFeatures;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
