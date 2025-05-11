package com.example.springstartherepart2.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service // We add the @Service stereotype annotation to instruct Spring to manage this class as a bean in its context.
@SessionScope // We use the @SessionScope annotation to change the scope of the bean to session.
public class LoggedUserManagementService {

    // Every time a user successfully logs in, we store its name in this bean's username attribute.
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
