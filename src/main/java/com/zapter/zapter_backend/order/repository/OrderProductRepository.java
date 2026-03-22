package com.zapter.zapter_backend.order.repository;

import com.zapter.zapter_backend.order.domain.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long>{

}
