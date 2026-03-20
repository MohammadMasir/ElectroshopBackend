package com.electroshop.electroshop_backend.product.mapper;

import com.electroshop.electroshop_backend.product.domain.Product;
import com.electroshop.electroshop_backend.product.dto.prod.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	@Mapping(target = "stockStatus", ignore = true)
	Product toProduct(ProductDto newProduct);

	List<ProductDto> toListOfProductResponse(List<Product> product);

	ProductDto toProductResponse(Product product);

}
