package com.nnk.springboot.domain;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Objects;

@DynamicUpdate
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bidlist")
public class BidList {
    // TODO: Map columns in data table BIDLIST with corresponding java fields

    @Id
    @Column(name = "bidListId")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer bidListId;

    @Basic
    @NotEmpty(message = "Account is mandatory")
    @Column(name = "account")
    private String account;

    @Basic
    @NotEmpty(message = "Type is mandatory")
    @Column(name = "type")
    private String type;

    @Basic
    @NotNull(message= "ne peut pas être nul")
    @Column(name = "bidQuantity")
    private Double bidQuantity;

    @Basic
    @Column(name = "askQuantity")
    private Double askQuantity;

    @Basic
    @Column(name = "bid")
    private Double bid;

    @Basic
    @Column(name = "ask")
    private Double ask;

    @Basic
    @Column(name = "benchmark")
    private String benchmark;

    @Basic
    @Column(name = "bidListDate")
    private Timestamp bidListDate;

    @Basic
    @Column(name = "commentary")
    private String commentary;

    @Basic
    @Column(name = "security")
    private String security;

    @Basic
    @Column(name = "status")
    private String status;

    @Basic
    @Column(name = "trader")
    private String trader;

    @Basic
    @Column(name = "book")
    private String book;

    @Basic
    @Column(name = "creationName")
    private String creationName;

    @Basic
    @Column(name = "creationDate")
    private Timestamp creationDate;

    @Basic
    @Column(name = "revisionName")
    private String revisionName;

    @Basic
    @Column(name = "revisionDate")
    private Timestamp revisionDate;

    @Basic
    @Column(name = "dealName")
    private String dealName;

    @Basic
    @Column(name = "dealType")
    private String dealType;

    @Basic
    @Column(name = "sourceListId")
    private String sourceListId;

    @Basic
    @Column(name = "side")
    private String side;

    public BidList(String account_test, String type_test, double v) {
        account = account_test;
        type = type_test;

        // Todo : Modifier peut être
        bid = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BidList bidList = (BidList) o;
        return bidListId != null && Objects.equals(bidListId, bidList.bidListId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
