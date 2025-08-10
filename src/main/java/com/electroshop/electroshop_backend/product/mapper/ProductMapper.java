package com.electroshop.electroshop_backend.product.mapper;

import com.electroshop.electroshop_backend.product.domain.Product;
import com.electroshop.electroshop_backend.product.dto.ProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

	List<ProductResponse> toDtoAll(List<Product> product);

	ProductResponse toDto(Product product);
	Product toEntity(ProductResponse response);
	
}
