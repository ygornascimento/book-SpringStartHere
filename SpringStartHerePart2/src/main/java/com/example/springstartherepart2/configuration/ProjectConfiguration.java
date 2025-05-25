package com.example.springstartherepart2.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.example.springstartherepart2.controller",
        "com.example.springstartherepart2.model",
        "com.example.springstartherepart2.proxy",
        "com.example.springstartherepart2.repository",
        "com.example.springstartherepart2.service",
        "com.example.springstartherepart2.exceptions"})
/* We enable the OpenFeign clients and tell the OpenFeign dependency where to search for the proxy contracts. */
@EnableFeignClients(basePackages = "com.example.springstartherepart2.proxy")
public class ProjectConfiguration {

}
