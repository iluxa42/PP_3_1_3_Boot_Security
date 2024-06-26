package ru.kata.spring.boot_security.controllers;

import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.entities.User;
import ru.kata.spring.boot_security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.security.Principal;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/access-denied")
    public String accessDeniedPage() {
        return "access-denied";
    }

    @GetMapping("/user")
    public String showUser (Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "user-info";
    }
}