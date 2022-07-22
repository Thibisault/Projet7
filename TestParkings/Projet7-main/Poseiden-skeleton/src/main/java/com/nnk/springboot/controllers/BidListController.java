package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.service.BidlistService;
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
public class BidListController {

    @Autowired
    BidlistService bidlistService;

    @RequestMapping("/bidList/list")
    public String home(Model model)
    {
        model.addAttribute("allBidList", bidlistService.chercherTouteLesBidList());
        return "bidList/list";
    }
      
    @GetMapping("/bidList/add")
    public String addBidForm(BidList bid) {
        return "bidList/add";
    }

    @PostMapping("/bidList/validate")
    public String validate(@Valid BidList bidList, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "bidList/add";
        }else{
            bidlistService.creerNewBidlist(bidList);
            model.addAttribute("newBidlist", bidList);
        }
        return "bidList/add";
    }

    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("updateBidList", bidlistService.chercherByBidListId(id));
        return "bidList/update";
    }

    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid BidList bidList,
                            BindingResult result, Model model) {
        if(result.hasErrors()){
            return "redirect:/bidList/update/{id}";
        }else{
            bidList.setBidListId(id);
            bidlistService.creerNewBidlist(bidList);
            model.addAttribute("allBidList", bidlistService.chercherTouteLesBidList());
        }
        return "redirect:/bidList/list";
    }

    @GetMapping("/bidList/delete/{id}")
    public String showDeleteBid(@PathVariable("id") Integer id, Model model) {
        bidlistService.supprimerBidList(bidlistService.chercherByBidListId(id));
        model.addAttribute("allBidList", bidlistService.chercherTouteLesBidList());
        return "redirect:/bidList/list";
    }
}
