package com.electroshop.electroshop_backend.product.service;

import com.electroshop.electroshop_backend.product.repository.CategoryRepository;
import com.electroshop.electroshop_backend.product.repository.ModelRepository;
import org.springframework.stereotype.Service;

@Service
public class ModelService {
    private final ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository){
        this.modelRepository = modelRepository;
    }
}
