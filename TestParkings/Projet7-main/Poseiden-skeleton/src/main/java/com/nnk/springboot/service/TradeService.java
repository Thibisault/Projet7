package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TradeService {

    Logger logger = LoggerFactory.getLogger(TradeService.class);


    @Autowired
    TradeRepository tradeRepository;

    /**
     * Enregeistrer un Trade Dans la base de données
     *
     * @param trade
     */
    public void creerNewTrade(Trade trade) {
        logger.info("Action create new  Trade");
        tradeRepository.save(trade);
    }

    /**
     * Récuperer tout les Trade
     *
     * @return
     */
    public List<Trade> chercherTouteLesTrade() {
        List<Trade> tradeList = new ArrayList<>();
        tradeList = tradeRepository.findAll();
        logger.info("Action find all Trade");
        return tradeList;
    }

    /**
     * Recuperer un Trade par son tradeId
     * @param tradeId
     * @return
     */
    public Trade chercherByTradeId(Integer tradeId) {
        logger.info("Action find byId Trade");
        return tradeRepository.findByTradeId(tradeId).orElse(null);
    }

    /**
     * Supprimer un Trade de la base donnees
     * @param trade
     */
    public void supprimerTrade(Trade trade){
        logger.info("Action delte Trade");
        tradeRepository.delete(trade);
    }

}
