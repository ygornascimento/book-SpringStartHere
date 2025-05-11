package com.example.springstartherepart2.model;

import com.example.springstartherepart2.service.LoggedUserManagementService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope /* We use te @RequestScope annotation to change the bean's scope to request scope. This way, Spring creates
a new instance of the class for every HTTP Request */
public class LoginProcessor {

    private final LoggedUserManagementService loggedUserManagementService;

    private String username = "natalie"; // The bean stores the credentials as attributes.
    private String password = "password"; // The bean stores the credentials as attributes.

    // We auto-wire the LoggedUserManagementService bean in the LoginProcessor class to take care of the authentication logic.
    public LoginProcessor(LoggedUserManagementService loggedUserManagementService) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

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

        boolean loginResult = false;
        if ("natalie".equals(username) && "password".equals(password)) {
            loginResult = true;
            loggedUserManagementService.setUsername(username); // We store the username on the LoggedUserManagementService bean.
        }

        return loginResult;
    }
}
