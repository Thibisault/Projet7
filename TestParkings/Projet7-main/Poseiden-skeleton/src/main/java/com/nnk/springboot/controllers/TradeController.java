package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.service.TradeService;
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
public class TradeController {
    // TODO: Inject Trade com.nnk.springboot.service

    @Autowired
    TradeService tradeService;

    @Autowired
    TradeRepository tradeRepository;

    @RequestMapping("/trade/list")
    public String home(Model model)
    {
        // TODO: find all Trade, add to model
        model.addAttribute("allTrade", tradeService.chercherTouteLesTrade());
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(Trade bid) {
        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Trade list
        if(result.hasErrors()){
            return "trade/add";
        } else{
            tradeService.creerNewTrade(trade);
            model.addAttribute("newTrade", trade);
        }
        return "trade/add";
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Trade by Id and to model then show to the form
        model.addAttribute("updateTrade", tradeService.chercherByTradeId(id));
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call com.nnk.springboot.service to update Trade and return Trade list
        if(result.hasErrors()){
            return "redirect:trade/update/{id}";
        } else{
            trade.setTradeId(id);
            tradeRepository.save(trade);
            model.addAttribute("allTrade", tradeService.chercherTouteLesTrade());

        }
        return "redirect:/trade/list";
    }

    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Trade by Id and delete the Trade, return to Trade list
        tradeService.supprimerTrade(tradeService.chercherByTradeId(id));
        model.addAttribute("allTrade", tradeService.chercherTouteLesTrade());
        return "redirect:/trade/list";
    }
}
