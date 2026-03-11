package com.electroshop.electroshop_backend.product.mapper;

import com.electroshop.electroshop_backend.product.domain.Category;
import com.electroshop.electroshop_backend.product.dto.category.CategoryResponse;
import com.electroshop.electroshop_backend.product.dto.category.NewCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Category toCategory(NewCategory newCategory);

    List<CategoryResponse> toListOfCategoryResponse(List<Category> category);

    CategoryResponse toCategoryResponse(Category category);
}
