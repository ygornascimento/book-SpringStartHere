package org.example.config;

import org.example.Parrot;
import org.example.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example") // Telling Spring where to find classes with @Component stereotype annotation.
public class ProjectConfig {

}
