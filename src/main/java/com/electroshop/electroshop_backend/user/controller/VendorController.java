package com.electroshop.electroshop_backend.user.controller;

import com.electroshop.electroshop_backend.user.dto.vendor.VendorDto;
import com.electroshop.electroshop_backend.user.service.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService){
        this.vendorService = vendorService;
    }

    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN','SYSTEM_ADMIN')")
    @PostMapping("/new")
    public ResponseEntity<?> newVendor(VendorDto newVendor){
        try {
            vendorService.createVendor(newVendor);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity<?> getVendorDetail(){
        try {
            return new ResponseEntity<>(vendorService.get(),HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVendorById(@PathVariable Long id){
        try {
            return new ResponseEntity<>(vendorService.getById(id),HttpStatus.OK);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }


    @PreAuthorize("hasAnyAuthority('SUPER_ADMIN','SYSTEM_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVendorById(@PathVariable Long id){
        try {
            vendorService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e){
            throw new RuntimeException(e);
        }
    }
}
