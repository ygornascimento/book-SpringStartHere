package com.example.springstartherechapter12.configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.example.springstartherechapter12.controller",
        "com.example.springstartherechapter12.model",
        "com.example.springstartherechapter12.repository",})
public class ProjectConfiguration {

}
