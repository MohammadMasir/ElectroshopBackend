package com.zapter.zapter_backend.user.dto.admin;

import jakarta.validation.constraints.NotBlank;

public record AuthEmployee(

        @NotBlank(message = "Please enter Employee ID")
        String employeeId
) {
}
