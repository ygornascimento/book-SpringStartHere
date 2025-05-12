package com.example.springstartherepart2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /* Instead of repeating the @ResponseBOdy annotation for each method, we replace @Controller with @RestController.
@RestController is a combination of @Controller and @ResponseBOdy. We use @RestController to instruct Spring that all the
controller's actions are REST endpoints.  */
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping("/ciao")
    public String ciao() {
        return "Ciao!";
    }
}
