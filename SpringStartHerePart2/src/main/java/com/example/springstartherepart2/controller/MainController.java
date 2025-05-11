package com.example.springstartherepart2.controller;

import com.example.springstartherepart2.service.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;

    // We auto-wire the LoggedUserManagementService bean to find out if the user already logged in.
    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    public String home() {
        // We take the username value, which should be different than null if someone logged in.
        String username = loggedUserManagementService.getUsername();

        // If the user is not logged in, we redirect the user to the login page.
        if (username == null) {
            return "redirect:/";
        }

        // If the user is logged in, we return the view for the main page.
        return "main.html";
    }
}
