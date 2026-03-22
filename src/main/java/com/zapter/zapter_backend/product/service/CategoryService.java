package com.zapter.zapter_backend.product.service;

import com.zapter.zapter_backend.product.domain.Category;
import com.zapter.zapter_backend.product.dto.category.CategoryResponse;
import com.zapter.zapter_backend.product.dto.category.NewCategory;
import com.zapter.zapter_backend.product.mapper.CategoryMapper;
import com.zapter.zapter_backend.product.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper){
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public void create(NewCategory newCategory){
        Category category = categoryMapper.toCategory(newCategory);
        categoryRepository.save(category);
    }

    public void update(Category category){
        categoryRepository.save(category);
    }

    public void delete(Long id){
        try {
            categoryRepository.deleteById(id);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    public List<CategoryResponse> get(){
        try {
            return categoryMapper.toListOfCategoryResponse(categoryRepository.findAll());
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
    public CategoryResponse getById(Long id){
        try {
            return categoryMapper.toCategoryResponse(categoryRepository.findById(id).orElseThrow(RuntimeException::new));
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
}
