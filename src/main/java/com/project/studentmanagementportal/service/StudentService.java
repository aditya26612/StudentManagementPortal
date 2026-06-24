package com.project.studentmanagementportal.service;

import com.project.studentmanagementportal.dto.request.UpdateStudentRequest;
import com.project.studentmanagementportal.dto.response.StudentResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {

    StudentResponse getStudentById(Long studentId);

    List<StudentResponse> getAllStudents();

    StudentResponse updateStudent(
            Long studentId,
            UpdateStudentRequest request
    );

    void deleteStudent(Long studentId);

    List<StudentResponse> searchStudents(String keyword);

    Page<StudentResponse> getStudents(
            int page,
            int size
    );
}