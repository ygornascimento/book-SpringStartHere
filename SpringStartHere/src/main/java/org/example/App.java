package org.example;

import org.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        var context  = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = context.getBean(Parrot.class);
//        Parrot parrot = context.getBean("parrot", Parrot.class);
//        Parrot parrot2 = context.getBean("parrot2", Parrot.class);
//        Parrot parrot3 = context.getBean("riki", Parrot.class);

//        System.out.println( parrot.getName() );
//        System.out.println( parrot2.getName() );
//        System.out.println( parrot3.getName() );

//        String s = context.getBean(String.class);
//        System.out.println(s);
//
//        Integer n = context.getBean(Integer.class);
//        System.out.println(n);
        System.out.println(parrot);
        System.out.println(parrot.getName());
    }
}
