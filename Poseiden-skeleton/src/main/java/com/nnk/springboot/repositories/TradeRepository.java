package com.nnk.springboot.repositories;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.Timestamp;
import java.util.Optional;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer> {

    public Optional<Trade> findByTradeId(Integer tradeId);
    public Optional<Trade> findByAccount(String account);
    public Optional<Trade> findByType(String type);
    public Optional<Trade> findByBuyQuantity(Double buyQuantity);
    public Optional<Trade> findBySellQuantity(Double sellQuantity);
    public Optional<Trade> findByBuyPrice(Double buyPrice);
    public Optional<Trade> findBySellPrice(Double sellPrice);
    public Optional<Trade> findByBenchmark(String benchmark);
    public Optional<Trade> findByTradeDate(Timestamp tradeDate);
    public Optional<Trade> findBySecurity(String security);
    public Optional<Trade> findByStatus(String status);
    public Optional<Trade> findByTrader(String trader);
    public Optional<Trade> findByBook(String book);
    public Optional<Trade> findByCreationName(String creationName);
    public Optional<Trade> findByCreationDate(Timestamp creationDate);
    public Optional<Trade> findByRevisionName(String revisionName);
    public Optional<Trade> findByRevisionDate(Timestamp revisionDate);
    public Optional<Trade> findByDealName(String dealName);
    public Optional<Trade> findByDealType(String dealType);
    public Optional<Trade> findBySourceListId(String sourceListId);
    public Optional<Trade> findBySide(String side);

}
