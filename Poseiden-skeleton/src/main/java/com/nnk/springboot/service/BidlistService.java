package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class BidlistService {

    @Autowired
    BidList bidList;

    @Autowired
    BidListRepository bidListRepository;

    /**
     * Enregeistrer un bidList Dans la base de données
     * @param bidList
     */
    public void creerNewBildlist(BidList bidList){
       bidListRepository.save(bidList);
    }

    /**
     * Récuperer tout les BidList
     * @return
     */
    public List<BidList> chercherTouteLesBidList(){
        return bidListRepository.findAll();
    }

    /**
     * Chercher dans la table BidList une entité par chacune de ses colones
     * @param bidListId
     * @return
     */
    public BidList chercherByBidListId(Integer bidListId){ bidList = bidListRepository.findByBidListId(bidListId).orElse(null);return bidList; }
    public BidList chercherByaccount(String account){ bidList = bidListRepository.findByAccount(account).orElse(null);return bidList; }
    public BidList chercherBytype(String type){ bidList = bidListRepository.findByType(type).orElse(null);return bidList; }
    public BidList chercherBybidQuantity(Double bidQuantity){ bidList = bidListRepository.findByBidQuantity(bidQuantity).orElse(null);return bidList; }
    public BidList chercherByaskQuantity(Double askQuantity){ bidList = bidListRepository.findByAskQuantity(askQuantity).orElse(null);return bidList; }
    public BidList chercherBybid(Double bid){ bidList = bidListRepository.findByBid(bid).orElse(null);return bidList; }
    public BidList chercherByask(Double ask){ bidList = bidListRepository.findByAsk(ask).orElse(null);return bidList; }
    public BidList chercherBybenchmark(String benchmark){ bidList = bidListRepository.findByBenchmark(benchmark).orElse(null);return bidList; }
    public BidList chercherBybidListDate(Timestamp bidListDate){ bidList = bidListRepository.findByBidListDate(bidListDate).orElse(null);return bidList; }
    public BidList chercherBycommentary(String commentary){ bidList = bidListRepository.findByCommentary(commentary).orElse(null);return bidList; }
    public BidList chercherBysecurity(String security){ bidList = bidListRepository.findBySecurity(security).orElse(null);return bidList; }
    public BidList chercherBystatus(String status){ bidList = bidListRepository.findByStatus(status).orElse(null);return bidList; }
    public BidList chercherBytrader(String trader){ bidList = bidListRepository.findByTrader(trader).orElse(null);return bidList; }
    public BidList chercherBybook(String book){ bidList = bidListRepository.findByBook(book).orElse(null);return bidList; }
    public BidList chercherBycreationName(String creationName){ bidList = bidListRepository.findByCreationName(creationName).orElse(null);return bidList; }
    public BidList chercherBycreationDate(Timestamp creationDate){ bidList = bidListRepository.findByCreationDate(creationDate).orElse(null);return bidList; }
    public BidList chercherByrevisionName(String revisionName){ bidList = bidListRepository.findByRevisionName(revisionName).orElse(null);return bidList; }
    public BidList chercherByrevisionDate(Timestamp revisionDate){ bidList = bidListRepository.findByRevisionDate(revisionDate).orElse(null);return bidList; }
    public BidList chercherBydealName(String dealName){ bidList = bidListRepository.findByDealName(dealName).orElse(null);return bidList; }
    public BidList chercherBydealType(String dealType){ bidList = bidListRepository.findByDealType(dealType).orElse(null);return bidList; }
    public BidList chercherBysourceListId(String sourceListId){ bidList = bidListRepository.findBySourceListId(sourceListId).orElse(null);return bidList; }
    public BidList chercherByside(String side){ bidList = bidListRepository.findBySide(side).orElse(null);return bidList; }
}
