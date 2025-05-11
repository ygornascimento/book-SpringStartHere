package com.example.springstartherepart2.model;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope /* We use te @RequestScope annotation to change the bean's scope to request scope. This way, Spring creates
a new instance of the class for every HTTP Request */
public class LoginProcessor {
    private String username = "natalie"; // The bean stores the credentials as attributes.
    private String password = "password"; // The bean stores the credentials as attributes.

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login() { // The bean defines a method for implementing the login logic.
        String username = this.getUsername();
        String password = this.getPassword();

        if ("natalie".equals(username) && "password".equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
