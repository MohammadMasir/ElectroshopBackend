package com.electroshop.electroshop_backend.user.dto.admin;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record SetAdminPassword(

        @NotBlank(message = "Password cannot be blank!")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^+-=&*])[a-zA-Z0-9!@#$%+-=^&*]{8,}$", message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.")
        String password

) {}




























/*
        @NotBlank
        String firstname,
        @NotBlank
        String lastname,
        @Pattern(regexp = "^[7896][0-9]{9}$", message = "Enter valid phone number.")
        @Size(min = 10, max = 10)
        @NotBlank(message = "Please provide phone number.")
        String phoneNumber,
        @NotBlank(message = "please provide a valid email address")
        @Email
        String email,
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^+-=&*])[a-zA-Z0-9!@#$%+-=^&*]{8,}$", message = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.")
        @NotBlank
        String password
*/
        /*
        This could be further implemented with an email system where the generated ID for this individual admin
        would be sent for approval and then the generated admin id will be sent to the email-id. But as of now,
        we are leaving it as it is since right now there will be only one admin.
         */
