package com.example.demospringncc.service;

import com.example.demospringncc.dto.UserDTO;
import com.example.demospringncc.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserDTO registrationDto);
    User findByUsername(String username);

}
