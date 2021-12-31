package com.nnk.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.sql.Timestamp;

@Data
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
    @Column(name = "account")
    private String account;

    @Basic
    @Column(name = "type")
    private String type;

    @Basic
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

}
