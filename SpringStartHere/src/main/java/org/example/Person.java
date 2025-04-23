package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
/*The stereotype annotation @Component instructs Spring to create and add a bean to the Context of the type
of this class: Person. */
public class Person {
    private String name = "Ella";
    private final Parrot parrot; //We can now make the field final to ensure its value cannot be changed after initialization.

    @Autowired /* When Spring creates the bean of type Person, it calls the constructor annotated with @Autowired.
    Spring provides a bean of type Parrot from its Context as value of the parameter. We're using constructor injection
    over field injection, used in section 3.2.1. */
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
}