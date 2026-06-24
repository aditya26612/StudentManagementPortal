package com.project.studentmanagementportal.controller;

import com.project.studentmanagementportal.dto.request.UpdateStudentRequest;
import com.project.studentmanagementportal.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import com.project.studentmanagementportal.dto.response.StudentResponse;
import com.project.studentmanagementportal.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/profile")
    public String profile(
            HttpSession session,
            Model model
    ) {

        Long studentId =
                (Long) session.getAttribute(
                        SessionUtil.STUDENT_ID
                );

        if (studentId == null) {
            return "redirect:/login";
        }

        StudentResponse student =
                studentService.getStudentById(studentId);


        model.addAttribute("student", student);

        return "profile";
    }

    @GetMapping("/profile/edit")
    public String editProfile(
            HttpSession session,
            Model model
    ) {

        Long studentId =
                (Long) session.getAttribute(
                        SessionUtil.STUDENT_ID
                );

        if (studentId == null) {
            return "redirect:/login";
        }

        StudentResponse student =
                studentService.getStudentById(studentId);


        model.addAttribute("student", student);

        return "edit-profile";
    }

    @PostMapping("/profile/update")
    public String updateProfile(
            @Valid @ModelAttribute UpdateStudentRequest request,
            BindingResult bindingResult,
            HttpSession session
    ) {

        if (bindingResult.hasErrors()) {
            return "edit-profile";
        }

        Long studentId =
                (Long) session.getAttribute(
                        SessionUtil.STUDENT_ID
                );

        studentService.updateStudent(
                studentId,
                request
        );

        return "redirect:/profile";
    }


}