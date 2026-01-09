package com.electroshop.electroshop_backend.user.repository;

import com.electroshop.electroshop_backend.user.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

    Optional<UserDetails> findByAdminId(String id);
}
