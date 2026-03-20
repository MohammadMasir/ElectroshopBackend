package com.electroshop.electroshop_backend.product.repository;

import com.electroshop.electroshop_backend.user.domain.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Long> {
}
