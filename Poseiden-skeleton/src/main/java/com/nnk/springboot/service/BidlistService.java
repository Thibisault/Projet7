package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidlistService {

    @Autowired
    BidListRepository bidListRepository;


    public void creerNewBildlist(BidList bidList){

       bidListRepository.save(bidList);
    }
}
