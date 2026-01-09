package com.electroshop.electroshop_backend.user.service;

import com.electroshop.electroshop_backend.security.AdminPasswordGenerator;
import com.electroshop.electroshop_backend.user.domain.Admin;
import com.electroshop.electroshop_backend.user.domain.Employee;
import com.electroshop.electroshop_backend.user.repository.AdminRepository;
import com.electroshop.electroshop_backend.user.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final EmployeeRepository employeeRepository;
    private final TransactionTemplate transactionTemplate;
    private final AdminPasswordGenerator adminPasswordGenerator;

    public AdminService(
            EmployeeRepository employeeRepository,
            TransactionTemplate transactionTemplate,
            AdminRepository adminRepository,
            AdminPasswordGenerator adminPasswordGenerator
            ){
        this.employeeRepository = employeeRepository;
        this.transactionTemplate = transactionTemplate;
        this.adminRepository = adminRepository;
        this.adminPasswordGenerator = adminPasswordGenerator;
    }

    public String makeEmployeeAdmin(Long employeeId){
//        String eid = employeeId.toString();
        employeeRepository.updateRoleByUserId(employeeId);
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return createAdmin(employeeId);
    }

    public String createAdmin(Long employeeId){
        transactionTemplate.execute(status -> {
            try {
                Admin admin = new Admin();
                admin.setEmployeeId(employeeId);
                admin.setPassword(adminPasswordGenerator.generatePassword());
                adminRepository.save(admin);
                return sendMail(admin, employeeId);
//                return null;
            } catch (Exception e) {
                status.setRollbackOnly();
                throw new RuntimeException("Admin creation failed : " + e);
            }
        });
        return "";
    }

    private String sendMail(Admin admin, Long employeeId) throws NoSuchAlgorithmException{
        Long adminId = admin.getId();
        StringBuilder rand = new StringBuilder();
        SecureRandom secureRandom = SecureRandom.getInstanceStrong();
        for (int i=0; i<=4; i++){
            rand.append(secureRandom.nextInt(9));
        }
        String adminLoginId;
        StringBuilder firstName = new StringBuilder(), lastName = new StringBuilder();
        String[] fullnameObject = employeeRepository.findFirstLastNameById(employeeId);
        String fullnameRaw = Arrays.toString(fullnameObject);
        StringBuilder fullname = new StringBuilder(fullnameRaw.replaceAll("[\\[\\]]",""));
        boolean flag = false;
        for (int i=0;i<fullname.length();i++){
            String currentCharacter = String.valueOf(fullname.charAt(i));
            boolean checkDividerCharacter = currentCharacter.equals(",");

            if (checkDividerCharacter || flag){
                lastName.append(currentCharacter);
                flag = true;
            } else {
                firstName.append(currentCharacter);
            }
        }

        lastName.replace(0,1,"");
        System.out.println("firstname : "+ firstName + " lastname : " + lastName);
        String firstCombination = String.valueOf(firstName.charAt(0)) + String.valueOf(lastName.charAt(lastName.length()-1));
        String lastCombination = String.valueOf(firstName.charAt(1)) + String.valueOf(lastName.charAt(lastName.length()-2));
        adminLoginId = "adm-"+ firstCombination.toUpperCase() + lastCombination.toUpperCase() +"-"+ rand.toString();
        return adminLoginId;
    }
}
