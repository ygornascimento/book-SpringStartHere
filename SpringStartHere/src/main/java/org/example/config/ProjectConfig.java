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
    public Person person () {
        Person person = new Person ();
        person.setName("Ella");
        person.setParrot(parrot ()); /* We define the relationship between the person bean and the parrot bean
        by directly calling the method that returns the bean we want to set. This approach doesn't create two instances
        of parrot because when two methods annotated with @Bean call each other Spring knows you want to create a link
        between the beans. To check it out, in the Parrot class, just add a constructor like this:
        public Parrot() {
            System.out.println("Parrot created");
        }
        and you will see that just once "Parrot created" will be printed.
        */
        return person;
    }
}
