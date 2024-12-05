package com.example.register.service;

import com.example.register.DTO.EmployeeDTO;
import com.example.register.DTO.LoginDTO;
import com.example.register.entity.Employee;
import com.example.register.repository.EmployeeRepo;
import com.example.register.response.LoginResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import java.util.Optional;
@Service
public class EmployeeServiceImpl extends EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final PasswordEncoder passwordEncoder;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo, PasswordEncoder passwordEncoder) {
        this.employeeRepo = employeeRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.employeeName(),
                employeeDTO.email(),
                passwordEncoder.encode(employeeDTO.password())
        );
        employeeRepo.save(employee);
        return employee.getEmployeeName();
    }

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        Optional<Employee> employeeOpt = employeeRepo.findByEmail(loginDTO.email());
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            if (passwordEncoder.matches(loginDTO.password(), employee.getPassword())) {
                return new LoginResponse("Login Successful", true);
            } else {
                return new LoginResponse("Incorrect Password", false);
            }
        } else {
            return new LoginResponse("Email not found", false);
        }
    }
}
