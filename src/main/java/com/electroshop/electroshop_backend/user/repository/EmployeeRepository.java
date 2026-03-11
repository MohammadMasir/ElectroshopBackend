package com.electroshop.electroshop_backend.user.repository;

import com.electroshop.electroshop_backend.user.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT EXISTS(SELECT 1 FROM employee WHERE super_admin = 'YES' and eid = :employeeId)", nativeQuery = true)
    boolean isSuperAdmin(@Param("employeeId") Long employeeId);

    @Query(value = "SELECT first_name,last_name FROM employee WHERE eid = :employeeId", nativeQuery = true)
    String[] findFirstLastNameById(@Param("employeeId") Long employeeId);
}
