package com.nnk.springboot.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rating")
public class Rating {
    // TODO: Map columns in data table RATING with corresponding java fields

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;

    @NotEmpty(message="Must not be empty")
    String moodysRating;

    @NotEmpty(message="Must not be empty")
    String sandPRating;

    @NotEmpty(message="Must not be empty")
    String fitchRating;

    @NotNull(message="Must not be null")
    Integer orderNumber;

    public Rating(String moodys_rating, String sand_pRating, String fitch_rating, int i) {
        moodysRating = moodys_rating;
        sandPRating = sand_pRating;
        fitchRating = fitch_rating;
        orderNumber = i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Rating rating = (Rating) o;
        return id != null && Objects.equals(id, rating.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
