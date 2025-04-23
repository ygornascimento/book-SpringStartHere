package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
/*The stereotype annotation @Component instructs Spring to create and add a bean to the Context of the type
of this class: Person. */
public class Person {
    private String name = "Ella";
    private Parrot parrot;

    public Person(Parrot parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    @Autowired
    /*
    You won’t often find developers applying the approach of using the setter for dependency injection.
    This approach has more disadvantages than advantages: it’s more challenging to read, it doesn’t allow you to
    make the field final, and it doesn’t help you in making the testing easier. Even so, I wanted to mention this possibility.
    */
    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}