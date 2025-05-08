package com.example.springstartherepart2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller/*
    The @Controller stereotype annotation marks this class as Spring MVC controller and adds a bean of this type
    to the Spring Context.
*/
public class MainController {

    /* Using Request Parameters

    @RequestMapping("/home") // We assign the controlle's action to an HTTP request path.
    public String home(@RequestParam String color, @RequestParam(required = false) String name, Model page) {
        page.addAttribute("username", name); // Adding the data we want the controller to send to the view.
        page.addAttribute("color", color); // The controller passes the color sent by the cliente to the view.
        return "home.html"; // The controller's action returns the view to be rendered into the HTTP response.
    } */

    //using Path Variables

    @RequestMapping("/home/{color}") // To define a path variable, you assign it a name and put it in the path between curly braces.
    public String home(@PathVariable String color, Model page) { /* You mark the parameter where you want to get the
    path variable with the @PathVariable annotation. The name of the parameter must be the same as the name of the variable in the path.*/
        page.addAttribute("username", "Ygor"); // Adding the data we want the controller to send to the view.
        page.addAttribute("color", color); // The controller passes the color sent by the cliente to the view.
        return "home.html"; // The controller's action returns the view to be rendered into the HTTP response.
    }
}
