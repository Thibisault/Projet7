package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RatingService {

    Logger logger = LoggerFactory.getLogger(RatingService.class);

    @Autowired
    RatingRepository ratingRepository;

    /**
     * Enregeistrer un rating Dans la base de données
     *
     * @param rating
     */
    public void creerNewRating(Rating rating) {
        logger.info("Action create new Rating");
        ratingRepository.save(rating);
    }

    /**
     * Récuperer tous les Rating
     *
     * @return
     */
    public List<Rating> chercherToutRating() {
        List<Rating> ratingList = new ArrayList<>();
        ratingList = ratingRepository.findAll();
        logger.info("Action find all Rating");
        return ratingList;
    }

    /**
     * Permet de chercher un Rating dans la BDD grâce à son id
     * @param id
     * @return
     */
    public Rating chercherById(Integer id) {
        logger.info("Action find byId Rating");
        return ratingRepository.findById(id).orElse(null);
    }

    /**
     * permet de supprimer un Rating dans la BDD
     * @param rating
     */
    public void supprimerBidList(Rating rating){
        logger.info("Action delete Rating");
        ratingRepository.delete(rating);
    }



}
