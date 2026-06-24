package com.project.studentmanagementportal.mapper;

import com.project.studentmanagementportal.constants.Role;
import com.project.studentmanagementportal.constants.StudentStatus;
import com.project.studentmanagementportal.dto.request.RegisterStudentRequest;
import com.project.studentmanagementportal.dto.request.UpdateStudentRequest;
import com.project.studentmanagementportal.dto.response.StudentResponse;
import com.project.studentmanagementportal.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(RegisterStudentRequest request) {

        return Student.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .course(request.getCourse())
                .status(StudentStatus.ACTIVE)
                .role(Role.STUDENT)
                .build();
    }

    public StudentResponse toResponse(Student student) {

        return StudentResponse.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .phone(student.getPhone())
                .course(student.getCourse())
                .status(StudentStatus.ACTIVE)
                .createdAt(student.getCreatedAt())
                .build();
    }

    public void updateEntity(
            UpdateStudentRequest request,
            Student student
    ) {

        student.setName(request.getName());
        student.setPhone(request.getPhone());
        student.setCourse(request.getCourse());
    }
}