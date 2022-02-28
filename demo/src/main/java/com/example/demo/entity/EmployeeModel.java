package com.example.demo.entity;

import lombok.Data;

@Data
public class EmployeeModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String position;
    private String phoneNumber;
}
