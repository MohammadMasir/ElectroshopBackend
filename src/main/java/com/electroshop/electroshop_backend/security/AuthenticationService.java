package com.electroshop.electroshop_backend.security;

import com.electroshop.electroshop_backend.user.domain.Employee;
import com.electroshop.electroshop_backend.user.domain.User;
import com.electroshop.electroshop_backend.user.dto.admin.AdminLogin;
import com.electroshop.electroshop_backend.user.dto.user.NewUser;
import com.electroshop.electroshop_backend.user.dto.user.UserLogin;
import com.electroshop.electroshop_backend.user.interfaces.Accounts;
import com.electroshop.electroshop_backend.user.mapper.EmployeeMapper;
import com.electroshop.electroshop_backend.user.mapper.UserMapper;
import com.electroshop.electroshop_backend.user.repository.AdminRepository;
import com.electroshop.electroshop_backend.user.repository.EmployeeRepository;
import com.electroshop.electroshop_backend.user.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

	private final UserRepository userRepository;
	private final EmployeeRepository employeeRepository;
	private final AdminRepository adminRepository;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	private final PasswordEncoder passwordEncoder;
	private final UserMapper userMapper;
	private final EmployeeMapper employeeMapper;

	public AuthenticationService(
			UserRepository userRepository,
			EmployeeRepository employeeRepository,
			AdminRepository adminRepository,
			JwtService jwtService,
			AuthenticationManager authenticationManager, 
			PasswordEncoder passwordEncoder,
			UserMapper userMapper,
			EmployeeMapper employeeMapper
			) {
		this.userRepository = userRepository;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
		this.userMapper = userMapper;
		this.employeeRepository = employeeRepository;
		this.employeeMapper = employeeMapper;
		this.adminRepository = adminRepository;
	}

	public boolean signup(NewUser newUserDto) {
        try {
            if (newUserDto != null){

                User newUser = userMapper.toUser(newUserDto, passwordEncoder);
                userRepository.save(newUser);
                return true;
            }
			return false;
        } catch (Exception e) {
            return false;
        }
	}
	
	public String login(Accounts account) {
		try {
			if (account instanceof UserLogin user){
//				UserLogin user = (UserLogin) account; I was doing typecasting whereas it could be done by "pattern variable".
				authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.phoneNumber(), user.password())
					);
				return jwtService.generateToken(userRepository.findByPhoneNumber(user.phoneNumber()).orElseThrow());
			} else if (account instanceof AdminLogin admin) {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(admin.adminId(), admin.password())
				);
				return jwtService.generateToken(adminRepository.findByAdminId(admin.adminId()).orElseThrow());
			}

			return  "";
	} catch (AuthenticationException e) {
		throw new RuntimeException(e);
		}
	}

	public boolean employeeExist(Long employeeId){
		Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee.isPresent();
		// Below is another way to do the same check whether the employee is Present :
		/* 		if (employee.isPresent()){
			return true;
		} else {
			return false;
		} */
	}
	
}

