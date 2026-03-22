package com.zapter.zapter_backend.security;

import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Component
public class AdminPasswordGenerator {

    String char_pool = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}|;:,.<>?";
    int passwordLength = 30;
    int index;

    public String generatePassword() throws NoSuchAlgorithmException{
        StringBuilder password = new StringBuilder();
        SecureRandom secureRandom = SecureRandom.getInstanceStrong();
        for (int i =0; i < passwordLength; i++){
            index = secureRandom.nextInt(char_pool.length());
            password.append(char_pool.charAt(index));
        }
            return password.toString();
    }

}
