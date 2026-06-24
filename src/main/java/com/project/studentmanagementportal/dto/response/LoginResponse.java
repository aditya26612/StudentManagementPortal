package com.project.studentmanagementportal.dto.response;

import com.project.studentmanagementportal.constants.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse {

    private Long studentId;

    private String studentName;

    private String email;

    private Role role;
}