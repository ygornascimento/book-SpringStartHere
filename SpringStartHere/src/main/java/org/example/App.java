package org.example;

import org.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main( String[] args ) {
        var springContext  = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person personInSpringContext = springContext.getBean(Person.class);

        System.out.println("Person's name: " + personInSpringContext.getName());
        System.out.println("Person's parrot: " + personInSpringContext.getParrot());
    }
}

//No changes in 3.2.2
