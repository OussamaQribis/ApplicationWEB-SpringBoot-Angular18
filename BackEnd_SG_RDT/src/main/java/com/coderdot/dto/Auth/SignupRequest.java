package com.coderdot.dto.Auth;

import lombok.Data;

@Data
public class SignupRequest {

    private Long id;
    private String email;
    private String name;
    private String password;
    private int userRole;


}
