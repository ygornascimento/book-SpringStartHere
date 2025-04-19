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
//        System.out.println(parrot);
//        System.out.println(parrot.getName());

        //1. Instance we want to add to the Spring Context
        Parrot x = new Parrot();
        x.setName("Kiki");

        //Define a Java interface Supplier to return this instace
        Supplier<Parrot> parrotSupplier = () -> x;

        //Call the registerBean() method to add the instance to the Spring Context.
        context.registerBean("parrot1",
                Parrot.class,
                parrotSupplier,
                bc -> bc.setPrimary(true));

        //To verify the bean is now in the Context, we refer to the parrot bean and  print its name in the console.
        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

    }
}
