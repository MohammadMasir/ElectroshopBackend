package com.electroshop.electroshop_backend.user.repository;

import com.electroshop.electroshop_backend.user.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

}
