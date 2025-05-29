package com.electroshop.electroshop_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.electroshop.electroshop_backend.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

}
