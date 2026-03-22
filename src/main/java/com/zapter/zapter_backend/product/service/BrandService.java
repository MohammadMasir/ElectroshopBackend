package com.zapter.zapter_backend.product.service;

import com.zapter.zapter_backend.product.domain.Brand;
import com.zapter.zapter_backend.product.dto.brand.BrandResponse;
import com.zapter.zapter_backend.product.dto.brand.NewBrand;
import com.zapter.zapter_backend.product.mapper.BrandMapper;
import com.zapter.zapter_backend.product.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public BrandService(BrandRepository brandRepository, BrandMapper brandMapper){
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    public void create(NewBrand newBrand){
        brandRepository.save(brandMapper.toBrand(newBrand));
    }

    public void update(Brand brand){
        brandRepository.save(brand);
    }

    public void delete(Long id){
        try {
            brandRepository.deleteById(id);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    public List<BrandResponse> get(){
        try {
            return brandMapper.toListOfBrandResponse(brandRepository.findAll());
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
    public BrandResponse getById(Long id){
        try {
            return brandMapper.toBrandResponse(brandRepository.findById(id).orElseThrow(RuntimeException::new));
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
}
