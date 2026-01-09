package com.electroshop.electroshop_backend.user.mapper;

import com.electroshop.electroshop_backend.user.domain.Employee;
import com.electroshop.electroshop_backend.user.dto.admin.AuthEmployee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "firstName", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "eid", source = "employeeId")
    Employee toEmployee(AuthEmployee employee);

}
