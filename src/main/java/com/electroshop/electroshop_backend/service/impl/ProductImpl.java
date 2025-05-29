package com.electroshop.electroshop_backend.service.impl;

import java.util.List;

import com.electroshop.electroshop_backend.domain.Product;
import com.electroshop.electroshop_backend.dto.product.ProductResponse;
import com.electroshop.electroshop_backend.mapper.ProductMapper;
import com.electroshop.electroshop_backend.repository.ProductDetailsRepository;
import com.electroshop.electroshop_backend.repository.ProductRepository;
import com.electroshop.electroshop_backend.service.ProductService;

public class ProductImpl implements ProductService{
	
	private ProductRepository productRepository;
	private ProductDetailsRepository productDetailsRepository;
	private ProductMapper productMapper;
	
	public void ProductService(ProductRepository productRepository, ProductDetailsRepository productDetailsRepository) {
		this.productRepository = productRepository;
		this.productDetailsRepository = productDetailsRepository;
	}
	
	public List<ProductResponse> getAll(){
		
		List<Product> products = productRepository.findAll();
	    return productMapper.toDtoAll(products);
	}
	
	public ProductResponse byId(Long id) {
		
		return productRepository.findById(id)
				.map(productMapper::toDto)
				.orElse(new ProductResponse(null, null, null, null, null, null, null, null, null, null));
	}
	
	 
	
	
}
