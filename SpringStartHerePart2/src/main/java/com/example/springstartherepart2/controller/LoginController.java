package com.example.springstartherepart2.controller;

import com.example.springstartherepart2.model.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam String username, @RequestParam String password, Model model) {

        boolean loggedIn = loginProcessor.login();

        if(loggedIn) {
            model.addAttribute("message", "You are already logged in!");
        } else {
            model.addAttribute("message", "Login failed!");
        }

        return "login.html";
    }
}
