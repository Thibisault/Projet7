package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class BidlistService {

    @Autowired
    BidListRepository bidListRepository;

    /**
     * Enregeistrer un bidList Dans la base de données
     *
     * @param bidList
     */
    public BidList creerNewBidlist(BidList bidList) {
        return bidListRepository.save(bidList);
    }

    /**
     * Récuperer tout les BidList
     *
     * @return
     */
    public List<BidList> chercherTouteLesBidList() {
        List<BidList> bidList = new ArrayList<>();
        bidList = bidListRepository.findAll();
        return bidList;
    }

    public void supprimerBidList(BidList bidList){
        bidListRepository.delete(bidList);
    }


    /**
     * Chercher dans la table BidList une entité par chacune de ses colones
     *
     * @param bidListId
     * @return
     */
    public BidList chercherByBidListId(Integer bidListId) {
        return bidListRepository.findByBidListId(bidListId).orElse(null);
    }

    public BidList chercherByaccount(String account) {
        return bidListRepository.findByAccount(account).orElse(null);
    }

    public BidList chercherBytype(String type) {
        return bidListRepository.findByType(type).orElse(null);
    }

    public BidList chercherBybidQuantity(Double bidQuantity) {
        return bidListRepository.findByBidQuantity(bidQuantity).orElse(null);
    }

    public BidList chercherByaskQuantity(Double askQuantity) {
        return bidListRepository.findByAskQuantity(askQuantity).orElse(null);
    }

    public BidList chercherBybid(Double bid) {
        return bidListRepository.findByBid(bid).orElse(null);
    }

    public BidList chercherByask(Double ask) {
        return bidListRepository.findByAsk(ask).orElse(null);
    }

    public BidList chercherBybenchmark(String benchmark) {
        return bidListRepository.findByBenchmark(benchmark).orElse(null);
    }

    public BidList chercherBybidListDate(Timestamp bidListDate) {
        return bidListRepository.findByBidListDate(bidListDate).orElse(null);
    }

    public BidList chercherBycommentary(String commentary) {
        return bidListRepository.findByCommentary(commentary).orElse(null);
    }

    public BidList chercherBysecurity(String security) {
        return bidListRepository.findBySecurity(security).orElse(null);
    }

    public BidList chercherBystatus(String status) {
        return bidListRepository.findByStatus(status).orElse(null);
    }

    public BidList chercherBytrader(String trader) {
        return bidListRepository.findByTrader(trader).orElse(null);
    }

    public BidList chercherBybook(String book) {
        return bidListRepository.findByBook(book).orElse(null);
    }

    public BidList chercherBycreationName(String creationName) {
        return bidListRepository.findByCreationName(creationName).orElse(null);
    }

    public BidList chercherBycreationDate(Timestamp creationDate) {
        return bidListRepository.findByCreationDate(creationDate).orElse(null);
    }

    public BidList chercherByrevisionName(String revisionName) {
        return bidListRepository.findByRevisionName(revisionName).orElse(null);
    }

    public BidList chercherByrevisionDate(Timestamp revisionDate) {
        return bidListRepository.findByRevisionDate(revisionDate).orElse(null);
    }

    public BidList chercherBydealName(String dealName) {
        return bidListRepository.findByDealName(dealName).orElse(null);
    }

    public BidList chercherBydealType(String dealType) {
        return bidListRepository.findByDealType(dealType).orElse(null);
    }

    public BidList chercherBysourceListId(String sourceListId) {
        return bidListRepository.findBySourceListId(sourceListId).orElse(null);
    }

    public BidList chercherByside(String side) {
        return bidListRepository.findBySide(side).orElse(null);
    }
}
