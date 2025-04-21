package org.example;

import org.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        var springContext  = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Person person = springContext.getBean(Person.class);
        Parrot parrot = springContext.getBean(Parrot.class);

        System.out.println("Person's name: " + person.getName());
        System.out.println("Parrot's name: " + parrot.getName());
        System.out.println("Person's parrot: " + person.getParrot());

    }
}
