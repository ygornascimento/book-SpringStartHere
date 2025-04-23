package org.example.config;

import org.example.Parrot;
import org.example.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot () {
        Parrot parrot = new Parrot ();
        parrot.setName("Koko");
        return parrot;
    }

    @Bean
    public Person person (Parrot parrot) {
        Person person = new Person ();
        person.setName("Ella");
        person.setParrot(parrot); /* Instead of directly calling the method that defines the bean we wish to refer to,
        (parrot ()) we add a parameter to the method of the corresponding type of object, and we rely on Spring to
        provide us a value through that parameter. With this approach, it doesn't matter if the bean we want to refer
        to is defined with a method annotated with @Bean or using stereotype annotation like @Component.

        1. We instruct Spring to provide a bean from its Context by defining a parameter for the method. Line 18
        2. We set the value of the person's attribute with the reference Spring provided. Line 21

        We can then use the provided bean (parrot) when creating the second one (person). The result is the has-A
        relationship between the two beans. The person has-A (Owns) the parrot.
        */
        return person;
    }
}
