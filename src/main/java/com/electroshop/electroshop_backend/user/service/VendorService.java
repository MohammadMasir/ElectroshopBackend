package com.electroshop.electroshop_backend.user.service;

import com.electroshop.electroshop_backend.user.domain.Vendor;
import com.electroshop.electroshop_backend.user.dto.vendor.VendorDto;
import com.electroshop.electroshop_backend.user.mapper.VendorMapper;
import com.electroshop.electroshop_backend.user.repository.VendorRepository;

import java.util.List;

public class VendorService {

    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    public VendorService(
            VendorRepository vendorRepository,
            VendorMapper vendorMapper
    ){
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }

    public void createVendor(VendorDto VendorDto){
        try {
            vendorRepository.save(vendorMapper.toVendor(VendorDto));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Vendor Vendor){
        vendorRepository.save(Vendor);
    }

    public void delete(Long id){
        try {
            vendorRepository.deleteById(id);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    public List<VendorDto> get(){
        try {
            return vendorMapper.toListOfVendorDto(vendorRepository.findAll());
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
    public VendorDto getById(Long id){
        try {
            return vendorMapper.toListOfVendorDto(vendorRepository.findById(id).orElseThrow(RuntimeException::new));
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
}
