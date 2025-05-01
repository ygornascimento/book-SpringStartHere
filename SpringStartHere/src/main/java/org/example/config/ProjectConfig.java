package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy // Enables the aspects mechanism in our Spring app.
@ComponentScan(basePackages = {"org.example.services", "org.example.aspects"})
public class ProjectConfig {

}
