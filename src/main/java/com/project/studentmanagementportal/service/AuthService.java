package com.project.studentmanagementportal.service;

import com.project.studentmanagementportal.dto.request.LoginRequest;
import com.project.studentmanagementportal.dto.request.RegisterStudentRequest;
import com.project.studentmanagementportal.dto.response.LoginResponse;
import com.project.studentmanagementportal.dto.response.StudentResponse;

public interface AuthService {

    StudentResponse register(RegisterStudentRequest request);

    LoginResponse login(LoginRequest request);

}