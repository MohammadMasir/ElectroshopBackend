package com.electroshop.electroshop_backend.service;

import java.util.List;

import com.electroshop.electroshop_backend.dto.product.ProductResponse;

public interface ProductService {
	
	List<ProductResponse> getAll();
	ProductResponse byId(Long id);
	
}
