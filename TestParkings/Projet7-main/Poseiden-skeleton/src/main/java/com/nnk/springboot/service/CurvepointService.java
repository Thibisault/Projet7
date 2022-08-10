package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CurvepointService {

    Logger logger = LoggerFactory.getLogger(CurvepointService.class);

    @Autowired
    CurvePointRepository curvePointRepository;

    /**
     * Enregeistrer un bidList Dans la base de données
     *
     * @param curvePoint
     * @return
     */
    public void creerNewCurvepointService(CurvePoint curvePoint) {
        logger.info("Action create CurvePoint");
        curvePointRepository.save(curvePoint);
    }

    /**
     * Permet de recupérer tout les CurvePoint de la BDD
     * @return
     */
    public List<CurvePoint> chercherTouteLesCurvesPoint() {
        List<CurvePoint> curvePointList = new ArrayList<>();
        curvePointList = curvePointRepository.findAll();
        logger.info("Action chercher all CurvePoint");
        return curvePointList;
    }

    /**
     * Permet de supprimer un CurvePoint de la BDD
     * @param curvePoint
     */
    public void supprimerBidList(CurvePoint curvePoint){
        logger.info("Action delete CurvePoint");
        curvePointRepository.delete(curvePoint);
    }

    /**
     * Permet de chercher un CurvePoint dans la BDD grâce à id
     * @param id
     * @return
     */
    public CurvePoint chercherById(Integer id) {
        return curvePointRepository.findById(id).orElse(null);
    }

    /**
     * Permet de chercher un CurvePoint dans la BDD grâce à curveId
     * @param id
     * @return
     */
    public CurvePoint chercherByCurveId(Integer id) {
        return curvePointRepository.findByCurveId(id).orElse(null);
    }

    /**
     * Permet de chercher un CurvePoint dans la BDD grâce à term
     * @param term
     * @return
     */
    public CurvePoint chercherByTerm(Double term) {
        return curvePointRepository.findByTerm(term).orElse(null);
    }

    /**
     * Permet de chercher un CurvePoint dans la BDD grâce à value
     * @param value
     * @return
     */
    public CurvePoint chercherByValue(Double value) {
        return curvePointRepository.findByValue(value).orElse(null);
    }
}
