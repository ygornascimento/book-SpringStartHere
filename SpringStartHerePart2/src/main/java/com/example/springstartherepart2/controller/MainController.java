package com.example.springstartherepart2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller// We annotate the class with the @Controller stereotype annotation.
public class MainController {

    @RequestMapping("/home") //We use the @RequestMapping annotation to associate the action with an HTTP request path.
    public String home() {
        return "home.html"; // We return the HTML document name that contains the details we want the browser to display.
    }
}
