package com.nnk.springboot.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "curvepoint")
public class CurvePoint {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;

    @NotNull(message = "Must not be null")
    Integer curveId;

    Timestamp asOfDate;

    @NotNull(message = "Must not be null")
    Double term;

    @NotNull(message = "Must not be null")
    Double value;

    Timestamp creationDate;

    public CurvePoint(int i, double v, double v1) {
        curveId = i;
        term = v;
        value = v1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CurvePoint that = (CurvePoint) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
