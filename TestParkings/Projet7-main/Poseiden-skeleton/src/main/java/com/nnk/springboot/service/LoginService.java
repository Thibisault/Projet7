package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    SecurityConfig securityConfig = new SecurityConfig();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public User seConnecter(String userName, String password) throws Exception {
        User user = (User) userService.loadUserByUsername(userName);
        if (securityConfig.passwordEncoder().matches(password, user.getPassword())) {
            return user;
        }
        throw new Exception("Le mot de passe ne correspond pas au pseudo");
    }

}