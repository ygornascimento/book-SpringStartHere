package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
/*The stereotype annotation @Component instructs Spring to create and add a bean to the Context of the type
of this class: Person. */
public class Person {
    private String name = "Ella";
    @Autowired
    /*We instruct Spring to provide a bean from its Context and set it directly as the value of the field, annotated
    with @Autowired. This way we establish a relationship between the two beans.
    Using the @Autowired annotation over the field, we instruct Spring to provide a value for that field from its Context.
    Spring creates the two beans, person and parrot, and injects the parrot object to the field of the bean of type person. */
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