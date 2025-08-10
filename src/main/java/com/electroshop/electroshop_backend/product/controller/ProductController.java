package com.electroshop.electroshop_backend.product.controller;

import com.electroshop.electroshop_backend.product.dto.ProductResponse;
import com.electroshop.electroshop_backend.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getProduct(){
        return;
    }

}
