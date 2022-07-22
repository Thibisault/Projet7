package com.nnk.springboot.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trade")
public class Trade {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer tradeId;


    @NotEmpty(message="Must not be empty")
    String account;

    @NotEmpty(message="Must not be empty")
    String type;

    @NotNull(message="must not be null")
    Double buyQuantity;

    Double sellQuantity;
    Double buyPrice;
    Double sellPrice;
    String benchmark;
    Timestamp tradeDate;
    String security;
    String status;
    String trader;
    String book;
    String creationName;
    Timestamp creationDate;
    String revisionName;
    Timestamp revisionDate;
    String dealName;
    String dealType;
    String sourceListId;
    String side;

    public Trade(String trade_account, String type) {
        account = trade_account;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Trade trade = (Trade) o;
        return tradeId != null && Objects.equals(tradeId, trade.tradeId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
