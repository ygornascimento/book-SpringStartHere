package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // Marks the contiguration class.
@ComponentScan( /* Tell Spring in which package to search for tha classes annotated with stereotype annotations.
Observe that the model package is not specified because it doesn't contain classes annotated with stereotype annotations. */
        basePackages = {"org.example.proxies",
                        "org.example.services",
                        "org.example.repositories"})
public class ProjectConfig {

}
