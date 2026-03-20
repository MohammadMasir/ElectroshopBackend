package com.electroshop.electroshop_backend.product.service;

import com.electroshop.electroshop_backend.product.dto.prod.ProductDto;
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

    public List<ProductDto> getProducts(){
        try{
            return productMapper.toListOfProductResponse(productRepository.findAll());
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void createProd(ProductDto newProduct){
        try {
            productRepository.save(productMapper.toProduct(newProduct));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}
