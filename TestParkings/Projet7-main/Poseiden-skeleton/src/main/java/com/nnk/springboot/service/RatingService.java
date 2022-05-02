package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingService {

    @Autowired
    RatingRepository ratingRepository;

    /**
     * Enregeistrer un rating Dans la base de données
     *
     * @param rating
     */
    public void creerNewRating(Rating rating) {
        ratingRepository.save(rating);
    }

    /**
     * Récuperer tout les Rating
     *
     * @return
     */
    public List<Rating> chercherToutRating() {
        List<Rating> ratingList = new ArrayList<>();
        ratingList = ratingRepository.findAll();
        return ratingList;
    }

    public Rating chercherById(Integer id) {
        return ratingRepository.findById(id).orElse(null);
    }

    public void supprimerBidList(Rating rating){
        ratingRepository.delete(rating);
    }



}
