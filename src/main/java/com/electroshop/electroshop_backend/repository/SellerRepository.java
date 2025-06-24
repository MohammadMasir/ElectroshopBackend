package com.electroshop.electroshop_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electroshop.electroshop_backend.domain.Brand;
import com.electroshop.electroshop_backend.domain.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{

}
