package com.nnk.springboot.service;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RatingServiceTest extends TestCase {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private GeneratorHelpService generatorHelpService;

    private void supprimerRatingTestDansBDD(List<Rating> ratingList){
        while (ratingList.size() > 0){
            ratingRepository.delete(ratingList.get(0));
            ratingList.remove(0);
        }
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreerNewRating() {
        List<Rating> ratingList = generatorHelpService.generatorRatingTest(2);
        List<Integer> ratingIdList = new ArrayList<>();

        for (Rating rating : ratingList){
            ratingIdList.add(rating.getId());
        }
        for (Integer id : ratingIdList) {
            assertNotNull(ratingService.chercherById(id));
        }
        this.supprimerRatingTestDansBDD(ratingList);
    }

    @Test
    public void testChercherToutRating() {
        int nombreDeGeneration = 2;
        int nombreTotalDeRatingAvantAjout = ratingService.chercherToutRating().size();
        List<Rating> ratingList = generatorHelpService.generatorRatingTest(nombreDeGeneration);
        int nombreTotalDeRatingApresAjout = ratingService.chercherToutRating().size();
        assertEquals(nombreTotalDeRatingAvantAjout + nombreDeGeneration, nombreTotalDeRatingApresAjout);
        this.supprimerRatingTestDansBDD(ratingList);
    }

    @Test
    public void testChercherById() {
        List<Rating> ratingList = generatorHelpService.generatorRatingTest(2);
        List<Integer> ratingIdList = new ArrayList<>();

        for (Rating rating : ratingList){
            ratingIdList.add(rating.getId());
        }

        for (Integer id : ratingIdList) {
            assertEquals(ratingService.chercherById(id).getId(), id);
        }
        this.supprimerRatingTestDansBDD(ratingList);
    }

    @Test
    public void testSupprimerBidList() {
        List<Rating> ratingList = generatorHelpService.generatorRatingTest(2);
        List<Integer> ratingIdList = new ArrayList<>();

        for (Rating rating : ratingList) {
            ratingIdList.add(rating.getId());
        }
        for (Integer id : ratingIdList) {
            assertNotNull(ratingService.chercherById(id));
        }

        for (Integer id : ratingIdList) {
            Rating rating = ratingService.chercherById(id);
            ratingService.supprimerBidList(rating);
            assertNull(ratingService.chercherById(id));
        }
    }
}