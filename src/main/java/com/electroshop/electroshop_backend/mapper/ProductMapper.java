package com.electroshop.electroshop_backend.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.electroshop.electroshop_backend.domain.Product;
import com.electroshop.electroshop_backend.dto.product.ProductResponse;

@Mapper
public interface ProductMapper {

	List<ProductResponse> toDtoAll(List<Product> product);
	ProductResponse toDto(Product product);
	Product toEntity(ProductResponse response);
	
}
