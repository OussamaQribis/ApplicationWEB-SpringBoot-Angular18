package com.coderdot.services.Auth;

import com.coderdot.dto.Auth.SignupRequest;
import com.coderdot.entities.User;

public interface AuthService {
    User createUser(SignupRequest signupRequest);
}
