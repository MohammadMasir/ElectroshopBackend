package com.electroshop.electroshop_backend.product.mapper;

import com.electroshop.electroshop_backend.product.domain.Brand;
import com.electroshop.electroshop_backend.product.dto.brand.BrandResponse;
import com.electroshop.electroshop_backend.product.dto.brand.NewBrand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Brand toBrand(NewBrand newBrand);

    List<BrandResponse> toListOfBrandResponse(List<Brand> brand);

    BrandResponse toBrandResponse(Brand brand);
}
