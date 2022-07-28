package com.nnk.springboot.security;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.domain.UserType;
import com.nnk.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService  {

    CustomOAuth2User customOAuth2User;

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user =  super.loadUser(userRequest);
        String login = (String) user.getAttributes().get("login");
        if(!userRepository.findByUsername(login).isPresent()) {
            User userBdd = new User();
            userBdd.setUserType(UserType.EXTERNAL);
            userBdd.setFullname(login);
            userBdd.setUsername(login);
            userBdd.setRole("USER");
            userBdd.setPassword("**********");
            userRepository.save(userBdd);
        }
        return new CustomOAuth2User(user);
    }
}
