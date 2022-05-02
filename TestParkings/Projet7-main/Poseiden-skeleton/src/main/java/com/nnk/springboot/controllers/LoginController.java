package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Map;


@Controller
@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    private final OAuth2AuthorizedClientService auth2AuthorizedClientService;

    public LoginController(OAuth2AuthorizedClientService auth2AuthorizedClientService) {
        this.auth2AuthorizedClientService = null;
    }

    @RequestMapping("/*")
    public String getUserInformation(Principal user)
    {
        StringBuffer userInfo = new StringBuffer();
        if (user instanceof UsernamePasswordAuthenticationToken){
            userInfo.append(getUsernameLoginPasswordLoginInfo(user));
        } else if (user instanceof OAuth2AuthenticationToken){
            userInfo.append(getOauth2LoginInfo(user));
        }
        return userInfo.toString();
    }

    private StringBuffer getOauth2LoginInfo(Principal user){
        StringBuffer protectedInfo = new StringBuffer();
        OAuth2AuthenticationToken authToken = ((OAuth2AuthenticationToken) user);
        OAuth2AuthorizedClient authClient =  this.auth2AuthorizedClientService
                .loadAuthorizedClient(authToken.getAuthorizedClientRegistrationId(),authToken.getName());
        Map<String, Object> userDetails = ((DefaultOAuth2User) authToken.getPrincipal()).getAttributes();
        String userToken = authClient.getAccessToken().getTokenValue();
        protectedInfo.append("Welcome, " + userDetails.get("name")+ "<br><br>");
        protectedInfo.append("email: " + userDetails.get("email")+ "<br><br>");
        protectedInfo.append("Access Token: " + userToken + "<br><br>");
        return protectedInfo;
    }

    private StringBuffer getUsernameLoginPasswordLoginInfo(Principal user){
        StringBuffer userNameInfo = new StringBuffer();
        UsernamePasswordAuthenticationToken token = ((UsernamePasswordAuthenticationToken)user);
        if(token.isAuthenticated()) {
            User u = (User) token.getPrincipal();
            userNameInfo.append("welcome, " + u.getUsername());
        }
                else {
                    userNameInfo.append("NA");
            }
        return userNameInfo;
    }

    @GetMapping("login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }



    @GetMapping("logout")
    public ModelAndView logout() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @GetMapping("secure/article-details")
    public ModelAndView getAllUserArticles() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("users", userRepository.findAll());
        mav.setViewName("user/list");
        return mav;
    }


    @GetMapping("error")
    public ModelAndView error() {
        ModelAndView mav = new ModelAndView();
        String errorMessage= "You are not authorized for the requested data.";
        mav.addObject("errorMsg", errorMessage);
        mav.setViewName("403");
        return mav;
    }
}
