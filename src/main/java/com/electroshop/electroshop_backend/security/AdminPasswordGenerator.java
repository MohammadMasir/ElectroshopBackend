package com.electroshop.electroshop_backend.security;

import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Component
public class AdminPasswordGenerator {

    public AdminPasswordGenerator() throws NoSuchAlgorithmException {}

    String char_pool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}|;:,.<>?";
    int passwordLength = 30;
    SecureRandom secureRandom = SecureRandom.getInstanceStrong();
    StringBuilder password = new StringBuilder();
    int index;

    public String generatePassword(){
        for (int i =0; i <= passwordLength; i++){
            index = secureRandom.nextInt(char_pool.length());
            password.append(char_pool.charAt(index));
        }
            return password.toString();
    }

}
