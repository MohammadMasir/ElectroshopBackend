package com.electroshop.electroshop_backend.product.mapper;

import com.electroshop.electroshop_backend.product.domain.Product;
import com.electroshop.electroshop_backend.product.dto.prod.ProductAdd;
import com.electroshop.electroshop_backend.product.dto.prod.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	List<ProductResponse> toDtoAll(List<Product> product);

	ProductResponse toDto(Product product);

//	@Mappings({
//			@Mapping(target = "", source = "")
//	})
	Product toEntity(ProductAdd newProduct);
	
}
