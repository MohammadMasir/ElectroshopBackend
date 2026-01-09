package com.electroshop.electroshop_backend.user.repository;

import com.electroshop.electroshop_backend.user.domain.Employee;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Modifying
    @Query(value = "UPDATE employee SET role = 'SYSTEM_ADMIN' where eid = :employeeId", nativeQuery = true)
    void updateRoleByUserId(@Param("employeeId") Long employeeId);

    @Query(value = "SELECT first_name,last_name FROM employee WHERE eid = :employeeId", nativeQuery = true)
    String[] findFirstLastNameById(@Param("employeeId") Long employeeId);
}
