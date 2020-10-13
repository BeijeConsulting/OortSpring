package it.beije.oort.gregori.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.oort.gregori.biblioteca.Utente;
import it.beije.oort.gregori.biblioteca.service.UtenteService;

@Controller
public class LoginController {
	
	@Autowired
	private UtenteService utenteService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("login...");
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String email, @RequestParam String password, Model model) {
		System.out.println("login post...");
		
		// query on db
		
		Utente utente = utenteService.findByEmailAndPassword(email, password);
		
		model.addAttribute("utente", utente);
		
		// if utente is admin -> return home admin
		// else -> return home user
				
		return "login";
	}

}
