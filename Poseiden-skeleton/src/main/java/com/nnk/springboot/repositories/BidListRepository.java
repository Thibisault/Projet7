package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.BidList;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.security.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface BidListRepository extends JpaRepository<BidList, Integer>, JpaSpecificationExecutor<BidList> {

    public List<BidList> findAll(Specification<BidList> bidListSpecification);


    public Optional<BidList> findByBidListId(Integer bidListId);
    public Optional<BidList> findByAccount(String account);
    public Optional<BidList> findByType(String type);
    public Optional<BidList> findByBidQuantity(Double bidQuantity);
    public Optional<BidList> findByAskQuantity(Double askQuantity);
    public Optional<BidList> findByBid(Double bid);
    public Optional<BidList> findByAsk(Double ask);
    public Optional<BidList> findByBenchmark(String benchmark);
    public Optional<BidList> findByBidListDate(java.sql.Timestamp bidListDate);
    public Optional<BidList> findByCommentary(String commentary);
    public Optional<BidList> findBySecurity(String security);
    public Optional<BidList> findByStatus(String status);
    public Optional<BidList> findByTrader(String trader);
    public Optional<BidList> findByBook(String book);
    public Optional<BidList> findByCreationName(String creationName);
    public Optional<BidList> findByCreationDate(java.sql.Timestamp creationDate);
    public Optional<BidList> findByRevisionName(String revisionName);
    public Optional<BidList> findByRevisionDate(java.sql.Timestamp revisionDate);
    public Optional<BidList> findByDealName(String dealName);
    public Optional<BidList> findByDealType(String dealType);
    public Optional<BidList> findBySourceListId(String sourceListId);
    public Optional<BidList> findBySide(String side);

}
