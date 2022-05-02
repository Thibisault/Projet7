package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    public Optional<Rating> findById(Integer id);
    public Optional<Rating> findByMoodysRating(String moodysRating);
    public Optional<Rating> findBySandPRating(String sandPRating);
    public Optional<Rating> findByFitchRating(String fitchRating);
    public Optional<Rating> findByOrderNumber(Integer orderNumber);

}
