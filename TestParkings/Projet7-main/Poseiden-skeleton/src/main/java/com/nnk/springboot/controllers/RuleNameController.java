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
    // TODO: Inject RuleName com.nnk.springboot.service

    @Autowired
    RulenameService rulenameService;

    @Autowired
    RuleNameRepository ruleNameRepository;

    @RequestMapping("/ruleName/list")
    public String home(Model model)
    {
        // TODO: find all RuleName, add to model
        model.addAttribute("allRuleName", rulenameService.chercherToutRuleName());
        return "ruleName/list";
    }

    @GetMapping("/ruleName/add")
    public String addRuleForm(RuleName bid) {
        return "ruleName/add";
    }

    @PostMapping("/ruleName/validate")
    public String validate(@Valid RuleName ruleName, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return RuleName list
        if(result.hasErrors()){
            return "ruleName/add";
        } else{
            rulenameService.creerNewRuleName(ruleName);
            model.addAttribute("newRuleName", ruleName);
        }
        return "ruleName/add";
    }

    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get RuleName by Id and to model then show to the form
        model.addAttribute("updateRuleName", rulenameService.chercherById(id));
        return "ruleName/update";
    }

    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call com.nnk.springboot.service to update RuleName and return RuleName list
        if(result.hasErrors()){
            return "redirect:ruleName/update/{id}";
        } else {
            ruleName.setId(id);
            ruleNameRepository.save(ruleName);
            model.addAttribute("allRuleName", rulenameService.chercherToutRuleName());
        }
        return "redirect:/ruleName/list";
    }

    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
        // TODO: Find RuleName by Id and delete the RuleName, return to Rule list
        rulenameService.supprimerBidList(rulenameService.chercherById(id));
        model.addAttribute("allRuleName", rulenameService.chercherToutRuleName());
        return "redirect:/ruleName/list";
    }
}
