package org.example;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/*Using the @Component stereotype annotation over the class,
we instruct Spring to create an instance of this class
and add it to its Context*/
@Component
public class Parrot {
    private String name;

    @PostConstruct
    public void init() {
        this.name = "Kiki from here";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
