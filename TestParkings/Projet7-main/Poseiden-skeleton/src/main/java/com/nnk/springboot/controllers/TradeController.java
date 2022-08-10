package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.service.TradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(TradeController.class);


    @Autowired
    TradeService tradeService;

    /**
     * Permet de récuperer tout les Trades et de les affichers
     * @param model
     * @return
     */
    @RequestMapping("/trade/list")
    public String home(Model model)
    {
        model.addAttribute("allTrade", tradeService.chercherTouteLesTrade());
        logger.info("Action getList TradeController");
        return "trade/list";
    }

    /**
     * Permet d'afficher le formualaire de création de Trade
     * @param bid
     * @return
     */
    @GetMapping("/trade/add")
    public String addUser(Trade bid) {
        logger.info("Action getAdd TradeController");
        return "trade/add";
    }

    /**
     * Permet d'enregistrer un nouveau trade dans la BDD
     * @param trade
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/trade/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
        if(result.hasErrors()){
            logger.info("Action postAdd error TradeController");
            return "trade/add";
        } else{
            tradeService.creerNewTrade(trade);
            model.addAttribute("newTrade", trade);
            logger.info("Action postAdd TradeController");
        }
        return "trade/add";
    }

    /**
     * Permet de récuperer le formulaire de mise à jour d'un trade par son Id
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("updateTrade", tradeService.chercherByTradeId(id));
        logger.info("Action getUpdate TradeController");
        return "trade/update";
    }

    /**
     * Permet de mettre à jour un trade
     * @param id
     * @param trade
     * @param result
     * @param model
     * @return
     */
    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                             BindingResult result, Model model) {
        if(result.hasErrors()){
            logger.info("Action postUpdate error TradeController");
            return "redirect:trade/update/{id}";
        } else{
            trade.setTradeId(id);
            tradeService.creerNewTrade(trade);
            model.addAttribute("allTrade", tradeService.chercherTouteLesTrade());
            logger.info("Action postUpdate TradeController");
        }
        return "redirect:/trade/list";
    }

    /**
     * Permet de supprimer un Trade de la BDD
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        tradeService.supprimerTrade(tradeService.chercherByTradeId(id));
        model.addAttribute("allTrade", tradeService.chercherTouteLesTrade());
        logger.info("Action getDelete TradeController");
        return "redirect:/trade/list";
    }
}
