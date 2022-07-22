package com.nnk.springboot.service;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
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
public class CurvepointServiceTest extends TestCase {

    @Autowired
    private CurvepointService curvepointService;

    @Autowired
    private CurvePointRepository curvePointRepository;

    @Autowired
    private GeneratorHelpService generatorHelpService;

    private void supprimerCruvePointTestDansBDD(List<CurvePoint> curvePointList){
        while (curvePointList.size() > 0){
            curvePointRepository.delete(curvePointList.get(0));
            curvePointList.remove(0);
        }
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreerNewCurvepointService() {
        List<CurvePoint> curvePointList = generatorHelpService.generatorCurvePointTest(2);
        List<Integer> curvePointIdList = new ArrayList<>();

        for (CurvePoint curvePoint : curvePointList){
            curvePointIdList.add(curvePoint.getId());
        }
        for (Integer curvePointId : curvePointIdList) {
            assertNotNull(curvepointService.chercherById(curvePointId));
        }
        this.supprimerCruvePointTestDansBDD(curvePointList);
    }

    @Test
    public void testChercherTouteLesCurvesPoint() {
        int nombreDeGeneration = 2;
        int nombreTotalDeCurvePointAvantAjout = curvepointService.chercherTouteLesCurvesPoint().size();
        List<CurvePoint> curvePointList = generatorHelpService.generatorCurvePointTest(nombreDeGeneration);
        int nombreTotalDeCurvePointApresAjout = curvepointService.chercherTouteLesCurvesPoint().size();
        assertEquals(nombreTotalDeCurvePointAvantAjout + nombreDeGeneration, nombreTotalDeCurvePointApresAjout);
        this.supprimerCruvePointTestDansBDD(curvePointList);
    }

    @Test
    public void testSupprimerBidList() {
        List<CurvePoint> curvePointList = generatorHelpService.generatorCurvePointTest(2);
        List<Integer> curvePointIdList = new ArrayList<>();

        for (CurvePoint curvePoint : curvePointList){
            curvePointIdList.add(curvePoint.getId());
        }
        for (Integer curvePointId : curvePointIdList) {
            assertNotNull(curvepointService.chercherById(curvePointId));
        }

        for (Integer curvePointId : curvePointIdList) {
            CurvePoint curvePoint = curvepointService.chercherById(curvePointId);
            curvepointService.supprimerBidList(curvePoint);
            assertNull(curvepointService.chercherById(curvePointId));
        }
    }

    @Test
    public void testChercherById() {
        List<CurvePoint> curvePointList = generatorHelpService.generatorCurvePointTest(2);
        List<Integer> curvePointIdList = new ArrayList<>();

        for (CurvePoint curvePoint : curvePointList){
            curvePointIdList.add(curvePoint.getId());
        }

        for (Integer id : curvePointIdList) {
            assertEquals(curvepointService.chercherById(id).getId(), id);
        }
        this.supprimerCruvePointTestDansBDD(curvePointList);
    }

    @Test
    public void testChercherByCurveId() {
        List<CurvePoint> curvePointList = generatorHelpService.generatorCurvePointTest(2);
        List<Integer> curvePointCurveIdList = new ArrayList<>();

        for (CurvePoint curvePoint : curvePointList){
            curvePointCurveIdList.add(curvePoint.getCurveId());
        }

        for (Integer curveId : curvePointCurveIdList) {
            assertEquals(curvepointService.chercherByCurveId(curveId).getCurveId(), curveId);
        }
        this.supprimerCruvePointTestDansBDD(curvePointList);
    }

    @Test
    public void testChercherByTerm() {
        List<CurvePoint> curvePointList = generatorHelpService.generatorCurvePointTest(2);
        List<Double> curvePointTerm = new ArrayList<>();

        for (CurvePoint curvePoint : curvePointList){
            curvePointTerm.add(curvePoint.getTerm());
        }

        for (Double term : curvePointTerm) {
            assertEquals(curvepointService.chercherByTerm(term).getTerm(), term);
        }
        this.supprimerCruvePointTestDansBDD(curvePointList);
    }

    @Test
    public void testChercherByValue() {
        List<CurvePoint> curvePointList = generatorHelpService.generatorCurvePointTest(2);
        List<Double> curvePointValue = new ArrayList<>();

        for (CurvePoint curvePoint : curvePointList){
            curvePointValue.add(curvePoint.getValue());
        }

        for (Double value : curvePointValue) {
            assertEquals(curvepointService.chercherByValue(value).getValue(), value);
        }
        this.supprimerCruvePointTestDansBDD(curvePointList);
    }
}