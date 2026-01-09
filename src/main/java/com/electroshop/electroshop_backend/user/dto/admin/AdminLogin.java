package com.electroshop.electroshop_backend.user.dto.admin;

import com.electroshop.electroshop_backend.user.interfaces.AdminInterface;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AdminLogin(
        @Pattern(regexp = "adm-[a-zA-Z]{4}[0-9]{5}")
        @NotBlank(message = "id cannot be blank!")
        String id,
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^+-=&*])[a-zA-Z0-9!@#$%+-=^&*]{8,}$", message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.")
        @NotBlank(message = "password is required!")
        String password
) implements AdminInterface {
        @Override
        public String adminId() {
                return id;
        }
}
