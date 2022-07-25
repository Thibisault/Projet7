package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.LoginService;
import com.nnk.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @RequestMapping("/user/list")
    public String home(Model model)
    {
        model.addAttribute("allUser", userService.chercherTouteUser());
        return "user/list";
    }

    @GetMapping("/user/add")
    public String addUser(User bid) {
        return "user/add";
    }

    @PostMapping("/user/validate")
    public String validate(@Valid User user, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            loginService.validerConnection(user);
            model.addAttribute("user", userService.chercherTouteUser());
            return "redirect:/user/list";
        }
        return "user/add";
    }

    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        User user = userService.chercherByIdWithException(id);
        model.addAttribute("updateUser", user);
        return "user/update";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid User user,
                             BindingResult result, Model model) {

        if (result.hasErrors()) {
            int nombreErreur = result.getErrorCount();
            if (nombreErreur > 0) {
                if (nombreErreur > 1) {
                    return "redirect:{id}";
                } else {
                    if (!result.toString().contains("Password is mandatory")) {
                        return "redirect:{id}";
                    }
                }
            }
        }
        userService.updateUserSansChangerMDP(id, user);
        model.addAttribute("updateUser", userService.chercherTouteUser());
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        User user = userService.chercherByIdWithException(id);
        userService.supprimerUser(user);
        model.addAttribute("user", userService.chercherTouteUser());
        return "redirect:/user/list";
    }
}
