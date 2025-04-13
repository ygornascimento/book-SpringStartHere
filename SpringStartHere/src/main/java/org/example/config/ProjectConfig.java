package org.example.config;

import org.example.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    Parrot parrot() {
        var p = new Parrot();
        p.setName( "Koko" );
        return p;
    }

    @Bean
    String hello() {
        return "hello";
    }

    @Bean
    Integer ten() {
        return 10;
    }

    @Bean
    Parrot parrot2() {
        var p = new Parrot();
        p.setName( "Miki" );
        return p;
    }

    @Bean(name = "riki")
    Parrot parrot3() {
        var p = new Parrot();
        p.setName( "Riki" );
        return p;
    }
}
