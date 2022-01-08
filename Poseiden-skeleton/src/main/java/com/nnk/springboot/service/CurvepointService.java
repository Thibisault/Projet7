package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class CurvepointService {

    @Autowired
    CurvePointRepository curvePointRepository;

    @Autowired
    CurvePoint curvePoint;

    /**
     * Enregeistrer un bidList Dans la base de données
     * @param curvePoint
     * @return
     */
    public void creerNewCurvepointService(CurvePoint curvePoint){
        curvePointRepository.save(curvePoint);
    }

    /**
     * Chercher dans la table CurvePoint une entité par chacune de ses colones
     * @param id
     * @return
     */
    public CurvePoint chercherByCurveId(Integer id){ curvePoint = curvePointRepository.findByCurveId(id).orElse(null);return curvePoint; }
    public CurvePoint chercherByAsOfDate(Timestamp asOfDate){ curvePoint = curvePointRepository.findByAsOfDate(asOfDate).orElse(null);return curvePoint; }
    public CurvePoint chercherByTerm(Double term){ curvePoint = curvePointRepository.findByTerm(term).orElse(null);return curvePoint; }
    public CurvePoint chercherByValue(Double value){ curvePoint = curvePointRepository.findByValue(value).orElse(null);return curvePoint; }
    public CurvePoint chercherByCreationDate(Timestamp creationDate){ curvePoint = curvePointRepository.findByCreationDate(creationDate).orElse(null);return curvePoint; }

}
