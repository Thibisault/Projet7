package com.nnk.springboot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);


	/**
	 * Permet la redirection vers la page d'acceuil
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String home(Model model)
	{
		logger.info("Action getHome HomeController");
		return "home";
	}

	/**
	 * premet la vers la page home dédié à l'Admin
	 * @param model
	 * @return
	 */
	@RequestMapping("/admin/home")
	public String adminHome(Model model)
	{
		logger.info("Action getAdminHome HomeController");
		return "redirect:/bidList/list";
	}


}
