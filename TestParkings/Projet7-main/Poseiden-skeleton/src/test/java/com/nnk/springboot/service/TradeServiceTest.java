package com.nnk.springboot.service;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
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
public class TradeServiceTest extends TestCase {

    @Autowired
    private TradeService tradeService;

    @Autowired
    private TradeRepository tradeRepository;

    @Autowired
    private GeneratorHelpService generatorHelpService;

    private void supprimerTradeTestDansBDD(List<Trade> tradeList){
        while (tradeList.size() > 0){
            tradeRepository.delete(tradeList.get(0));
            tradeList.remove(0);
        }
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreerNewTrade() {
        List<Trade> tradeList = generatorHelpService.generatorTradeTest(2);
        List<Integer> tradeIdList = new ArrayList<>();

        for (Trade trade : tradeList){
            tradeIdList.add(trade.getTradeId());
        }
        for (Integer tradeId : tradeIdList) {
            assertNotNull(tradeService.chercherByTradeId(tradeId));
        }
        this.supprimerTradeTestDansBDD(tradeList);
    }

    @Test
    public void testChercherTouteLesTrade() {
        int nombreDeGeneration = 2;
        int nombreTotalDeTradeAvantAjout = tradeService.chercherTouteLesTrade().size();
        List<Trade> tradeList = generatorHelpService.generatorTradeTest(nombreDeGeneration);
        int nombreTotalDeTradeApresAjout = tradeService.chercherTouteLesTrade().size();
        assertEquals(nombreTotalDeTradeAvantAjout + nombreDeGeneration, nombreTotalDeTradeApresAjout);
        this.supprimerTradeTestDansBDD(tradeList);
    }

    @Test
    public void testChercherByTradeId() {
        List<Trade> tradeList = generatorHelpService.generatorTradeTest(2);
        List<Integer> tradeIdList = new ArrayList<>();

        for (Trade trade : tradeList){
            tradeIdList.add(trade.getTradeId());
        }

        for (Integer tradeId : tradeIdList) {
            assertEquals(tradeService.chercherByTradeId(tradeId).getTradeId(), tradeId);
        }
        this.supprimerTradeTestDansBDD(tradeList);
    }

    @Test
    public void testSupprimerTrade() {
        List<Trade> tradeList = generatorHelpService.generatorTradeTest(2);
        List<Integer> tradeIdList = new ArrayList<>();

        for (Trade curvePoint : tradeList) {
            tradeIdList.add(curvePoint.getTradeId());
        }
        for (Integer tradeId : tradeIdList) {
            assertNotNull(tradeService.chercherByTradeId(tradeId));
        }

        for (Integer tradeId : tradeIdList) {
            Trade trade = tradeService.chercherByTradeId(tradeId);
            tradeService.supprimerTrade(trade);
            assertNull(tradeService.chercherByTradeId(tradeId));
        }
    }
}