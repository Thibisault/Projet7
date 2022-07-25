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

    /**
     * Permet de récuperer la liste complête des Users et de les affichers
     * @param model
     * @return
     */
    @RequestMapping("/user/list")
    public String home(Model model)
    {
        model.addAttribute("allUser", userService.chercherTouteUser());
        return "user/list";
    }

    /**
     * Permet de récuperer le formulaire de création de User
     * @param bid
     * @return
     */
    @GetMapping("/user/add")
    public String addUser(User bid) {
        return "user/add";
    }

    /**
     * Permet de créer un nouveau User et de l'enregistrer dans la BDD
     * @param user
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/user/validate")
    public String validate(@Valid User user, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            loginService.validerConnection(user);
            model.addAttribute("user", userService.chercherTouteUser());
            return "redirect:/user/list";
        }
        return "user/add";
    }

    /**
     * Permet de récuperer le formulaire de mise à jour d'un User
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        User user = userService.chercherByIdWithException(id);
        model.addAttribute("updateUser", user);
        return "user/update";
    }

    /**
     * Permet de mettre un jour un User dans la BDD
     * @param id
     * @param user
     * @param result
     * @param model
     * @return
     */
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

    /**
     * Permet de supprimer un User dans la BDD
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        User user = userService.chercherByIdWithException(id);
        userService.supprimerUser(user);
        model.addAttribute("user", userService.chercherTouteUser());
        return "redirect:/user/list";
    }
}
