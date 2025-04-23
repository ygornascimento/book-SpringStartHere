package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
/*The stereotype annotation @Component instructs Spring to create and add a bean to the Context of the type
of this class: Person.

When Spring creates the bean of type Person, it also needs to provide a value for the constructor's parameter.
If multiple beans of the same type are available, Spring will choose the bean with the same name as the parameter.
*/
public class Person {
    private String name = "Ella";
    private final Parrot parrot;

    public Person(@Qualifier("parrot1") Parrot parrot) {
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