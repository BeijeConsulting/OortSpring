package it.beije.oort.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.service.UtentiService;

@Controller
public class UtentiController {

	@Autowired
	private UtentiService utentiService;
	
	@RequestMapping(value = "/CatalogoUtenti", method = RequestMethod.GET)
	public String catalogoUtenti(Model model) {	
		model.addAttribute("utenti", utentiService.loadUtenti());
		return "utenti";
	}
}
