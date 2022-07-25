package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RatingController {

    @Autowired
    RatingService ratingService;

    /**
     * Permet de récupérer, de stocker et d'afficher la liste de tout les Rating enregistré en BDD
     * @param model
     * @return
     */
    @RequestMapping("/rating/list")
    public String home(Model model)
    {
        model.addAttribute("allRating", ratingService.chercherToutRating());
        return "rating/list";
    }

    /**
     * Permet d'afficher le formulaire de création d'un Rating dans la BDD
     * @param rating
     * @return
     */
    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
        return "rating/add";
    }

    /**
     * Permet de créer un nouveau Rating dans la BDD
     * @param rating
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
        if(result.hasErrors()){
            return"rating/add";
        }
        ratingService.creerNewRating(rating);
        model.addAttribute("newRating", rating);
        return "rating/add";
    }

    /**
     * Permet d'afficher le formulaire pour la mise un jour d'un Rating particulié grâce à la récupération de son ID
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("updateRating", ratingService.chercherById(id));
        return "rating/update";
    }

    /**
     * Permet de mettre un jour un Rating en particulier récupéré grâce à son Id
     * @param id
     * @param rating
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating,
                             BindingResult result, Model model) {
        if (result.hasErrors()){
            return"redirect:rating/update/{id}";
        } else{
            rating.setId(id);
            ratingService.creerNewRating(rating);
            model.addAttribute("allRating", ratingService.chercherToutRating());
        }
        return "redirect:/rating/list";
    }

    /**
     * Permet de supprimer un Rating de la BDD
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        ratingService.supprimerBidList(ratingService.chercherById(id));
        model.addAttribute("allRating", ratingService.chercherToutRating());
        return "redirect:/rating/list";
    }
}
