package com.example.springstartherepart2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // We use the @Controller annotation to mark the class as a Spring MVC controller.
public class HelloController {

    @GetMapping("/hello") // We use @GetMapping annotation to associate the GET HTTP method and a path with the controller's action.
    @ResponseBody // We use the @ResponseBody annotation to inform the dispatcher servlet that this method doesn't return a view name but the HTTP response directly.
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/ciao")
    @ResponseBody
    public String ciao() {
        return "Ciao!";
    }
}
