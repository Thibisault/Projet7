package com.nnk.springboot.service;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RulenameService {

    @Autowired
    RuleNameRepository ruleNameRepository;

    /**
     * Enregeistrer un ruleName Dans la base de données
     *
     * @param ruleName
     */
    public void creerNewRuleName(RuleName ruleName) {
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
        return ruleName;
    }

    /**
     * permet de chercher un RuleName dans la BDD grâce à son ruleNameId
     * @param ruleNameId
     * @return
     */
    public RuleName chercherById(Integer ruleNameId) {
        return ruleNameRepository.findById(ruleNameId).orElse(null);
    }

    /**
     * Permet de supprimer un RuleName dans la BDD
     * @param ruleName
     */
    public void supprimerBidList(RuleName ruleName){
        ruleNameRepository.delete(ruleName);
    }


}
