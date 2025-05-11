package com.example.springstartherepart2.controller;

import com.example.springstartherepart2.service.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;

    // We auto-wire the LoggedUserManagementService bean to find out if the user already logged in.
    public MainController(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    @GetMapping("/main")
    // We get the logout request paramiter if present. We add a Model parameter to send the username to the view.
    public String home(@RequestParam(required = false) String logout, Model model) {

        // If the logout parameter is present, we erase the username from the LoggedUserManagementService bean.
        if (logout != null) {
            loggedUserManagementService.setUsername(null);
        }

        String username = loggedUserManagementService.getUsername();

        if (username == null) {
            return "redirect:/";
        }

        model.addAttribute("username", username); // We send the username to the view.
        return "main.html";
    }
}
