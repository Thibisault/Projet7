package com.nnk.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	/**
	 * Permet la redirection vers la page d'acceuil
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String home(Model model)
	{
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
		return "redirect:/bidList/list";
	}


}
