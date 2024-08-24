package com.coderdot.dto.Auth;

import com.coderdot.entities.User;

public record LoginResponse(String jwt, User user) {
}
