package com.electroshop.electroshop_backend.product.service;

import com.electroshop.electroshop_backend.product.dto.prod.ProductAdd;
import com.electroshop.electroshop_backend.product.dto.prod.ProductResponse;
import com.electroshop.electroshop_backend.product.mapper.ProductMapper;
import com.electroshop.electroshop_backend.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductResponse> getProducts(){
        try{
            return productMapper.toDtoAll(productRepository.findAll());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void createProd(ProductAdd newProduct){
        try {
            productRepository.save(productMapper.toEntity(newProduct));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
