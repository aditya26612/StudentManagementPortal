package com.project.studentmanagementportal.dto.response;

import com.project.studentmanagementportal.constants.Role;
import com.project.studentmanagementportal.constants.StudentStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponse {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String course;

    private StudentStatus status;

    private Role role;

    private LocalDateTime createdAt;
}