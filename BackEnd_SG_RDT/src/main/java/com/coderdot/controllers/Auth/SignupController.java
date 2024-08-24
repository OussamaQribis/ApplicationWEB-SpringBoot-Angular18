package com.coderdot.controllers.Auth;

import com.coderdot.dto.Auth.SignupRequest;
import com.coderdot.entities.User;
import com.coderdot.services.Auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignupController {

    private final AuthService authService;

    @Autowired
    public SignupController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public User signupCustomer(@RequestBody SignupRequest signupRequest) {
        User createdCustomer = authService.createUser(signupRequest);


        if (createdCustomer != null) {

            return createdCustomer;
        } else {
            return null;
        }
    }

}
