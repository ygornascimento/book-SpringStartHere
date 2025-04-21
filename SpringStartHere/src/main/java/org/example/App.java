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

        Person personInSpringContext = springContext.getBean(Person.class);
        Parrot parrotInSpringContext = springContext.getBean(Parrot.class);

        System.out.println("Person's name: " + personInSpringContext.getName());
        System.out.println("Parrot's name: " + parrotInSpringContext.getName());
        System.out.println("Person's parrot: " + personInSpringContext.getParrot()); /* It will be null, as it do not
        have relationship in Spring Context between the two classes, Person and Parrot */
    }
}
