package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TradeService {

    @Autowired
    TradeRepository tradeRepository;

    /**
     * Enregeistrer un Trade Dans la base de données
     *
     * @param trade
     */
    public void creerNewTrade(Trade trade) {
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
        return tradeList;
    }

    /**
     * Recuperer un Trade par son tradeId
     * @param tradeId
     * @return
     */
    public Trade chercherByTradeId(Integer tradeId) {
        return tradeRepository.findByTradeId(tradeId).orElse(null);
    }

    /**
     * Supprimer un Trade de la base donnees
     * @param trade
     */
    public void supprimerTrade(Trade trade){
        tradeRepository.delete(trade);
    }

}
