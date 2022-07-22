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

    @RequestMapping("/rating/list")
    public String home(Model model)
    {
        model.addAttribute("allRating", ratingService.chercherToutRating());
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
        if(result.hasErrors()){
            return"rating/add";
        }
        ratingService.creerNewRating(rating);
        model.addAttribute("newRating", rating);
        return "rating/add";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("updateRating", ratingService.chercherById(id));
        return "rating/update";
    }

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

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        ratingService.supprimerBidList(ratingService.chercherById(id));
        model.addAttribute("allRating", ratingService.chercherToutRating());
        return "redirect:/rating/list";
    }
}
