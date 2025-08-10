package com.electroshop.electroshop_backend.product.service;

import com.electroshop.electroshop_backend.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }



}
