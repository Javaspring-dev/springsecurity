package com.example.register.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(name = "employee_name", length = 255, nullable = false)
    private String employeeName;

    @Column(name = "email", length = 255, unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;


    public Employee(String employeeName, String email, String password) {
        this.employeeName = employeeName;
        this.email = email;
        this.password = password;
    }


        public String getEmployeeName () {
            return null;
        }
    public String getPassword() {
        return password;
    }

}

