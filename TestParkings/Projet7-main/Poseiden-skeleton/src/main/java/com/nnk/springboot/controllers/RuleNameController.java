package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.service.RulenameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RuleNameController {

    @Autowired
    RulenameService rulenameService;

    /**
     * Permet de récuperer, de stocker et d'afficher la liste de tout les RuleName
     * @param model
     * @return
     */
    @RequestMapping("/ruleName/list")
    public String home(Model model)
    {
        model.addAttribute("allRuleName", rulenameService.chercherToutRuleName());
        return "ruleName/list";
    }

    /**
     * Permet d'afficher le formulaire de création d'un nouveau RuleName
     * @param bid
     * @return
     */
    @GetMapping("/ruleName/add")
    public String addRuleForm(RuleName bid) {
        return "ruleName/add";
    }

    /**
     * Permet de créer un nouveau RuleName en BDD
     * @param ruleName
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/ruleName/validate")
    public String validate(@Valid RuleName ruleName, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "ruleName/add";
        } else{
            rulenameService.creerNewRuleName(ruleName);
            model.addAttribute("newRuleName", ruleName);
        }
        return "ruleName/add";
    }

    /**
     * Permet d'afficher le formulaire de mise à jour d'un RuleName précis par son Id
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("updateRuleName", rulenameService.chercherById(id));
        return "ruleName/update";
    }

    /**
     * Permet de mettre un jour un RuleName ciblé grâce à son Id
     * @param id
     * @param ruleName
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName,
                             BindingResult result, Model model) {
        if(result.hasErrors()){
            return "redirect:ruleName/update/{id}";
        } else {
            ruleName.setId(id);
            rulenameService.creerNewRuleName(ruleName);
            model.addAttribute("allRuleName", rulenameService.chercherToutRuleName());
        }
        return "redirect:/ruleName/list";
    }

    /**
     * Permet de supprimer un RuleName dans la BDD
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
        rulenameService.supprimerBidList(rulenameService.chercherById(id));
        model.addAttribute("allRuleName", rulenameService.chercherToutRuleName());
        return "redirect:/ruleName/list";
    }
}
