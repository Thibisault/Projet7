package com.nnk.springboot.service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RulenameServiceTest extends TestCase {

    @Autowired
    private RulenameService rulenameService;

    @Autowired
    private RuleNameRepository ruleNameRepository;

    @Autowired
    private GeneratorHelpService generatorHelpService;

    private void supprimerRuleNameTestDansBDD(List<RuleName> ruleNames){
        while (ruleNames.size() > 0){
            ruleNameRepository.delete(ruleNames.get(0));
            ruleNames.remove(0);
        }
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreerNewRuleName() {
        List<RuleName> ruleNameList = generatorHelpService.generatorRuleNameTest(2);
        List<Integer> ruleNameIdList = new ArrayList<>();

        for (RuleName ruleName : ruleNameList){
            ruleNameIdList.add(ruleName.getId());
        }
        for (Integer ruleNameId : ruleNameIdList) {
            assertNotNull(rulenameService.chercherById(ruleNameId));
        }
        this.supprimerRuleNameTestDansBDD(ruleNameList);
    }

    @Test
    public void testChercherToutRuleName() {
        int nombreDeGeneration = 2;
        int nombreTotalDeRuleNameAvantAjout = rulenameService.chercherToutRuleName().size();
        List<RuleName> ruleNameList = generatorHelpService.generatorRuleNameTest(nombreDeGeneration);
        int nombreTotalDeRuleNameApresAjout = rulenameService.chercherToutRuleName().size();
        assertEquals(nombreTotalDeRuleNameAvantAjout + nombreDeGeneration, nombreTotalDeRuleNameApresAjout);
        this.supprimerRuleNameTestDansBDD(ruleNameList);
    }

    @Test
    public void testChercherById() {
        List<RuleName> ruleNameList = generatorHelpService.generatorRuleNameTest(2);
        List<Integer> ruleNameIdList = new ArrayList<>();

        for (RuleName ruleName : ruleNameList){
            ruleNameIdList.add(ruleName.getId());
        }

        for (Integer id : ruleNameIdList) {
            assertEquals(rulenameService.chercherById(id).getId(), id);
        }
        this.supprimerRuleNameTestDansBDD(ruleNameList);
    }


    @Test
    public void testSupprimerBidList() {
        List<RuleName> ruleNameList = generatorHelpService.generatorRuleNameTest(2);
        List<Integer> ruleNameIdList = new ArrayList<>();

        for (RuleName ruleName : ruleNameList) {
            ruleNameIdList.add(ruleName.getId());
        }
        for (Integer ruleNameId : ruleNameIdList) {
            assertNotNull(rulenameService.chercherById(ruleNameId));
        }

        for (Integer id : ruleNameIdList) {
            RuleName ruleName = rulenameService.chercherById(id);
            rulenameService.supprimerBidList(ruleName);
            assertNull(rulenameService.chercherById(id));
        }
    }
}