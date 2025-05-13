package com.example.springstartherepart2.controller;

import com.example.springstartherepart2.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController/* Marking the class as a REST controller to add a bean in the Spring context and also inform the
dispatcher servlet not to look for a view when this method returns.*/
public class CountryController {

    @GetMapping("/france") //Mapping the controller's action to the HTTP GET method and /france path.
    public ResponseEntity<Country> france() {
        Country country = Country.of("France", 67);
        return ResponseEntity.status(HttpStatus.ACCEPTED) // Changes the HTTP response status to 202 Accepted.
                .header("continent", "Europe") //Adds three custom headers to the response.
                .header("capital", "Paris") //Adds three custom headers to the response.
                .header("favorite_food", "cheese and wine") //Adds three custom headers to the response.
                .body(country); // Sets the response body.
    }

    @GetMapping("/all")
    public List<Country> countries() {
        Country country = Country.of("France", 67);
        Country country2 = Country.of("Spain", 47);
        return List.of(country, country2); //Returning a collection in the HTTP Response Body.
    }
}
