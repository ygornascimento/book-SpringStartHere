package com.example.springstartherepart2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller/*
    The @Controller stereotype annotation marks this class as Spring MVC controller and adds a bean of this type
    to the Spring Context.
*/
public class MainController {

    @RequestMapping("/home") // We assign the controlle's action to an HTTP request path.
    public String home(@RequestParam String color, @RequestParam(required = false) String name, Model page) {
        page.addAttribute("username", name); // Adding the data we want the controller to send to the view.
        page.addAttribute("color", color); // The controller passes the color sent by the cliente to the view.
        return "home.html"; // The controller's action returns the view to be rendered into the HTTP response.
    }
}
