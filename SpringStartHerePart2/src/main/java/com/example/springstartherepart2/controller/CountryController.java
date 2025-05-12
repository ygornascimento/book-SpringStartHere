package com.example.springstartherepart2.controller;

import com.example.springstartherepart2.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController/* Marking the class as a REST controller to add a bean in the Spring context and also inform the
dispatcher servlet not to look for a view when this method returns.*/
public class CountryController {

    @GetMapping("/france") //Mapping the controller's action to the HTTP GET method and /france path.
    public Country france() {
        Country country = Country.of("France", 67);
        return country; //Returning an instance of type Country.
    }
}
