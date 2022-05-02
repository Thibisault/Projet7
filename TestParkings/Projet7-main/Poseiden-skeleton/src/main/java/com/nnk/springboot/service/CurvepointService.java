package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurvepointService {

    @Autowired
    CurvePointRepository curvePointRepository;


    /**
     * Enregeistrer un bidList Dans la base de données
     *
     * @param curvePoint
     * @return
     */
    public void creerNewCurvepointService(CurvePoint curvePoint) {
        curvePointRepository.save(curvePoint);
    }

    public List<CurvePoint> chercherTouteLesCurvesPoint() {
        List<CurvePoint> curvePointList = new ArrayList<>();
        curvePointList = curvePointRepository.findAll();
        return curvePointList;
    }


    public void supprimerBidList(CurvePoint curvePoint){
        curvePointRepository.delete(curvePoint);
    }

    /**
     * Chercher dans la table CurvePoint une entité par chacune de ses colones
     *
     * @param id
     * @return
     */

    public CurvePoint chercherById(Integer id) {
        return curvePointRepository.findById(id).orElse(null);
    }


    public CurvePoint chercherByCurveId(Integer id) {
        return curvePointRepository.findByCurveId(id).orElse(null);
    }

    public CurvePoint chercherByAsOfDate(Timestamp asOfDate) {
        return curvePointRepository.findByAsOfDate(asOfDate).orElse(null);
    }

    public CurvePoint chercherByTerm(Double term) {
        return curvePointRepository.findByTerm(term).orElse(null);
    }

    public CurvePoint chercherByValue(Double value) {
        return curvePointRepository.findByValue(value).orElse(null);
    }

    public CurvePoint chercherByCreationDate(Timestamp creationDate) {
        return curvePointRepository.findByCreationDate(creationDate).orElse(null);
    }

}
