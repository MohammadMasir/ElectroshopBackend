package com.electroshop.electroshop_backend.product.service;

import com.electroshop.electroshop_backend.product.repository.BrandRepository;
import com.electroshop.electroshop_backend.product.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }
}
