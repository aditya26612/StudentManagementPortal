package com.project.studentmanagementportal.controller;

import com.project.studentmanagementportal.constants.Role;
import com.project.studentmanagementportal.dto.request.LoginRequest;
import com.project.studentmanagementportal.dto.request.RegisterStudentRequest;
import com.project.studentmanagementportal.dto.response.LoginResponse;
import com.project.studentmanagementportal.service.AuthService;
import com.project.studentmanagementportal.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {

        model.addAttribute(
                "loginRequest",
                new LoginRequest()
        );

        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {

        model.addAttribute(
                "registerStudentRequest",
                new RegisterStudentRequest()
        );

        return "register";
    }

    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute RegisterStudentRequest request,
            BindingResult bindingResult
    ) {

        System.out.println("REGISTER HIT");

        if (bindingResult.hasErrors()) {

            bindingResult.getAllErrors()
                    .forEach(error ->
                            System.out.println(error.getDefaultMessage()));

            return "register";
        }

        System.out.println("VALIDATION PASSED");

        authService.register(request);

        return "redirect:/login";
    }
    @PostMapping("/login")
    public String login(
            @Valid @ModelAttribute LoginRequest request,
            BindingResult bindingResult,
            HttpSession session
    ) {

        if (bindingResult.hasErrors()) {
            return "login";
        }

        LoginResponse response =
                authService.login(request);

        session.setAttribute(
                SessionUtil.STUDENT_ID,
                response.getStudentId()
        );

        session.setAttribute(
                SessionUtil.STUDENT_NAME,
                response.getStudentName()
        );

        session.setAttribute(
                SessionUtil.ROLE,
                response.getRole()
        );

        if (response.getRole() == Role.ADMIN) {
            return "redirect:/admin/dashboard";
        }

        return "redirect:/profile";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }
}