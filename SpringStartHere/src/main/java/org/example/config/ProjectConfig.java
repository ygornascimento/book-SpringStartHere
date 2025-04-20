package org.example.config;

import org.example.Parrot;
import org.example.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "org.example")
public class ProjectConfig {
    @Bean
    public Parrot parrot () {
        Parrot parrot = new Parrot ();
        parrot.setName("Koko");
        return parrot;
    }

    @Bean
    public Person person () {
        Person person = new Person ();
        person.setName("Ella");
        return person;
    }
}
