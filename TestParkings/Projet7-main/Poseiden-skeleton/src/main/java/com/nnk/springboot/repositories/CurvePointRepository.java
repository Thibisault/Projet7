package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.CurvePoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurvePointRepository extends JpaRepository<CurvePoint, Integer> {

    public Optional<CurvePoint> findById(Integer id);
    public Optional<CurvePoint> findByCurveId(Integer curveId);
    public Optional<CurvePoint> findByAsOfDate(java.sql.Timestamp asOfDate);
    public Optional<CurvePoint> findByTerm(Double term);
    public Optional<CurvePoint> findByValue(Double value);
    public Optional<CurvePoint> findByCreationDate(java.sql.Timestamp creationDate);


}
