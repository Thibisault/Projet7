package com.nnk.springboot.controllers;

import com.nnk.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RestController
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    UserService userService;

    /**
     * Permet le redirection vers la page de login
     * @return
     */
    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        logger.info("Action getLogin LoginController");
        return mav;
    }

    /**
     * Permet la déconnexion du compte
     * @return
     */
    @GetMapping("/logout")
    public ModelAndView logout() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        logger.info("Action getLogout LoginController");
        return mav;
    }

    @GetMapping("secure/article-details")
    public ModelAndView getAllUserArticles() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("users", userService.chercherTouteUser());
        mav.setViewName("user/list");
        logger.info("Action getSecureArticleDetails LoginController");
        return mav;
    }


    /**
     * Permet d'afficher une page d'erreur
     * @return
     */
    @GetMapping("error")
    public ModelAndView error() {
        ModelAndView mav = new ModelAndView();
        String errorMessage= "You are not authorized for the requested data.";
        mav.addObject("errorMsg", errorMessage);
        mav.setViewName("403");
        logger.info("Action getError403 LoginController");
        return mav;
    }
}
