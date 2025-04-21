package org.example;


import org.springframework.stereotype.Component;
@Component
public class Person {
    private String name = "Ella";
    private Parrot parrot;

    /*
    Because the name of the constructor's parameter matches one of hte bean's names in the Spring Context,
    Spring injects that bean so the name of the parrot te app prints in the console is Miki.

    When Spring creates the bean of type Person, it also needs to provide a value for the constructor's parameter.
    If multiple beans of the same type are available, Spring will choose the bean with the same name as the parameter.
     */
    public Person(Parrot parrot2) {
        this.parrot = parrot2;
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

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }
}
