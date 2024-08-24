package com.coderdot.services.Auth;

import com.coderdot.dto.Auth.SignupRequest;
import com.coderdot.entities.User;
import com.coderdot.enums.UserRole;
import com.coderdot.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User createUser(SignupRequest signupRequest) {
        //Check if customer already exist
        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return null;
        }else{
            User customer = new User();
            BeanUtils.copyProperties(signupRequest,customer);
            if(signupRequest.getUserRole()==0){
                customer.setUserRole(UserRole.ADMIN);
            }
            if(signupRequest.getUserRole()==1){
                customer.setUserRole(UserRole.EMPLOYEE);
            }

            //Hash the password before saving
            String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
            customer.setPassword(hashPassword);
            User createdCustomer = userRepository.save(customer);
            customer.setId(createdCustomer.getId());
            return customer;}


    }
}
