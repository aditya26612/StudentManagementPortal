package com.project.studentmanagementportal.controller;

import com.project.studentmanagementportal.constants.Role;
import com.project.studentmanagementportal.dto.response.StudentResponse;
import com.project.studentmanagementportal.service.StudentService;
import com.project.studentmanagementportal.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final StudentService studentService;

    // this is helper
    private boolean isAdmin(HttpSession session) {

        Role role =
                (Role) session.getAttribute(
                        SessionUtil.ROLE
                );

        return role == Role.ADMIN;
    }

    @GetMapping("/dashboard")
    public String dashboard(
            HttpSession session,
            Model model
    ) {

        Role role = (Role) session.getAttribute(
                SessionUtil.ROLE
        );

        if (role == null) {
            return "redirect:/login";
        }

        if (role != Role.ADMIN) {
            return "redirect:/profile";
        }

        List<StudentResponse> students =
                studentService.getAllStudents();

        model.addAttribute(
                "totalStudents",
                students.size()
        );

        return "dashboard";
    }
    @GetMapping("/students")
    public String getAllStudents(
            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "5")
            int size,

            @RequestParam(required = false)
            String keyword,

            HttpSession session,
            Model model
    ) {

        if (!isAdmin(session)) {
            return "redirect:/profile";
        }

        if (keyword != null &&
                !keyword.trim().isEmpty()) {

            List<StudentResponse> students =
                    studentService.searchStudents(keyword);

            model.addAttribute(
                    "students",
                    students
            );

        } else {

            Page<StudentResponse> studentPage =
                    studentService.getStudents(
                            page,
                            size
                    );

            model.addAttribute(
                    "students",
                    studentPage.getContent()
            );

            model.addAttribute(
                    "currentPage",
                    page
            );

            model.addAttribute(
                    "totalPages",
                    studentPage.getTotalPages()
            );
        }

        return "students";
    }

    @GetMapping("/student/{id}")
    public String getStudent(
            @PathVariable Long id,
            HttpSession session,
            Model model
    ) {

        Role role = (Role) session.getAttribute(
                SessionUtil.ROLE
        );

        if (role == null) {
            return "redirect:/login";
        }

        StudentResponse student =
                studentService.getStudentById(id);

        model.addAttribute(
                "student",
                student
        );

        return "student-details";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(
            @PathVariable Long id,
            HttpSession session
    ) {

        Role role = (Role) session.getAttribute(
                SessionUtil.ROLE
        );

        if (role == null) {
            return "redirect:/login";
        }

        studentService.deleteStudent(id);

        return "redirect:/admin/students";
    }


}