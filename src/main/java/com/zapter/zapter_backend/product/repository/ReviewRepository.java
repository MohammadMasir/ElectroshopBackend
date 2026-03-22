package com.zapter.zapter_backend.product.repository;

import com.zapter.zapter_backend.product.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>{

}
