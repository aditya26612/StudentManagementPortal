package com.project.studentmanagementportal.service.impl;

import com.project.studentmanagementportal.constants.AppConstants;
import com.project.studentmanagementportal.dto.request.LoginRequest;
import com.project.studentmanagementportal.dto.request.RegisterStudentRequest;
import com.project.studentmanagementportal.dto.response.LoginResponse;
import com.project.studentmanagementportal.dto.response.StudentResponse;
import com.project.studentmanagementportal.entity.Student;
import com.project.studentmanagementportal.exception.InvalidCredentialsException;
import com.project.studentmanagementportal.exception.StudentAlreadyExistsException;
import com.project.studentmanagementportal.mapper.StudentMapper;
import com.project.studentmanagementportal.repository.StudentRepository;
import com.project.studentmanagementportal.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public StudentResponse register(RegisterStudentRequest request) {

        if (studentRepository.existsByEmail(request.getEmail())) {
            throw new StudentAlreadyExistsException(
                    AppConstants.EMAIL_ALREADY_EXISTS
            );
        }

        Student student = studentMapper.toEntity(request);

        student.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        Student savedStudent =
                studentRepository.save(student);

        log.info("Student registered successfully: {}",
                savedStudent.getEmail());

        return studentMapper.toResponse(savedStudent);
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        Student student =
                studentRepository.findByEmail(request.getEmail())
                        .orElseThrow(() ->
                                new InvalidCredentialsException(
                                        AppConstants.INVALID_CREDENTIALS
                                ));

        boolean passwordMatches =
                passwordEncoder.matches(
                        request.getPassword(),
                        student.getPassword()
                );

        if (!passwordMatches) {
            throw new InvalidCredentialsException(
                    AppConstants.INVALID_CREDENTIALS
            );
        }

        log.info("Login successful: {}", student.getEmail());

        return LoginResponse.builder()
                .studentId(student.getId())
                .studentName(student.getName())
                .email(student.getEmail())
                .role(student.getRole())
                .build();
    }
}