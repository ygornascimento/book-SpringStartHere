package org.example.config;

import org.example.Parrot;
import org.example.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("org.example")
public class ProjectConfig {

    @Bean
    public Parrot parrot1 (){
        Parrot parrot = new Parrot();
        parrot.setName("Koko");
        return parrot;
    }

    @Bean
    public Parrot parrot2 (){
        Parrot parrot = new Parrot();
        parrot.setName("Miki");
        return parrot;
    }
}
