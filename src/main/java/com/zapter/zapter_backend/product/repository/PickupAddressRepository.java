package com.zapter.zapter_backend.product.repository;

import com.zapter.zapter_backend.user.domain.PickupAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PickupAddressRepository extends JpaRepository<PickupAddress, Long> {
}
