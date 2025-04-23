package org.example.config;

import org.example.Parrot;
import org.example.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    /*
    In this section we discuss the scenario in which Spring needs to inject a value into a parameter or class field/property
    bus has multiple beans of the same type to choose from.

    Spring will provide the value of the bean  whose name is the same as the name of the parameter. One way to instruct
    Spring to provide you a specific instance from its context, when the context contains more than one instance of the
    same type, is to rely on the name of this instance. Just name the parameter the same as the instance you'd like Spring
    to provide you.

    **In real-world scenario, its better avoid relaying on the name of the parameter, which could be easily refactored
    and changed by mistake by another developer.

    Another way to express the intention to inject a specific bean is using the @Qualifier annotation.
    */

    @Bean
    public Parrot parrot1() {
        Parrot parrot = new Parrot();
        parrot.setName("Koko - Parrot 1");
        return parrot;
    }

    @Bean
    public Parrot parrot2() {
        Parrot parrot = new Parrot();
        parrot.setName("Miki - Parrot 2");
        return parrot;
    }

    @Bean
    public Person person(@Qualifier("parrot2") Parrot parrot2) { /*
    Using the @Qualifier annotation, you clearly mark your intention to inject a specific bean from the context.
    */
        Person person = new Person();
        person.setName("Ella");
        person.setParrot(parrot2);
        return person;
    }
}
