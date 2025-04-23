package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
/*The stereotype annotation @Component instructs Spring to create and add a bean to the Context of the type
of this class: Person. */
public class Person {
    private String name = "Ella";
    private Parrot parrot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }
    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}