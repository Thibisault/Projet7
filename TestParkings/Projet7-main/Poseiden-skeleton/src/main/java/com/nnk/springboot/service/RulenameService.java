package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RulenameService {

    Logger logger = LoggerFactory.getLogger(RulenameService.class);


    @Autowired
    RuleNameRepository ruleNameRepository;

    /**
     * Enregeistrer un ruleName Dans la base de données
     *
     * @param ruleName
     */
    public void creerNewRuleName(RuleName ruleName) {
        logger.info("Action create new RuleName");
        ruleNameRepository.save(ruleName);
    }

    /**
     * Récuperer tous les RuleName
     *
     * @return
     */
    public List<RuleName> chercherToutRuleName() {
        List<RuleName> ruleName = new ArrayList<>();
        ruleName = ruleNameRepository.findAll();
        logger.info("Action find all RuleName");
        return ruleName;
    }

    /**
     * permet de chercher un RuleName dans la BDD grâce à son ruleNameId
     * @param ruleNameId
     * @return
     */
    public RuleName chercherById(Integer ruleNameId) {
        logger.info("Action find byId RuleName");
        return ruleNameRepository.findById(ruleNameId).orElse(null);
    }

    /**
     * Permet de supprimer un RuleName dans la BDD
     * @param ruleName
     */
    public void supprimerBidList(RuleName ruleName){
        logger.info("Action delete RuleName");
        ruleNameRepository.delete(ruleName);
    }


}
