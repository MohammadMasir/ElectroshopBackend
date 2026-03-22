package com.zapter.zapter_backend.user.repository;

import com.zapter.zapter_backend.user.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT role from employee WHERE eid = :employeeId", nativeQuery = true) //SELECT role from employee WHERE EXISTS(SELECT 1 FROM employee WHERE eid = :employeeId) AND eid = :employeeId
    String ifEmployeeExistsGetRole(@Param("employeeId") Long employeeId);

    @Query(value = "SELECT first_name,last_name FROM employee WHERE eid = :employeeId", nativeQuery = true)
    String[] findFirstLastNameById(@Param("employeeId") Long employeeId);
}
