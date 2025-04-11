package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        var context  = new AnnotationConfigApplicationContext();
        System.out.println( "Hello World!" );
    }
}
