package it.beije.oort.gregori.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.gregori.biblioteca.Utente;
import it.beije.oort.gregori.biblioteca.service.UtenteService;

@Controller
public class UtenteController {
	
	@Autowired
	private UtenteService utenteService;
	
	@RequestMapping(value = "/utente/visualizza", method = RequestMethod.GET)
	public String visualizza(Model model) {
		System.out.println("visualizza...");
		
		List<Utente> utenti = utenteService.view();
		
		model.addAttribute("utenti", utenti);
		
		return "utente-visualizza";
	}
	
	@RequestMapping(value = "/utente/inserisci", method = RequestMethod.GET)
	public String inserisci() {
		System.out.println("inserisci...");
		
		return "utente-inserisci";
	}
	
	@RequestMapping(value = "/utente/modifica", method = RequestMethod.GET)
	public String modifica(Model model) {
		System.out.println("modifica...");
		
		return "utente-modifica";
	}
	
	@RequestMapping(value = "/utente/rimuovi", method = RequestMethod.GET)
	public String rimuovi(Model model) {
		System.out.println("rimuovi...");
		
		return "utente-rimuovi";
	}
	
	
	@RequestMapping(value = "/utente/ricerca", method = RequestMethod.GET)
	public String ricerca() {
		System.out.println("ricerca...");
		
		return "utente-ricerca";
	}
	
}
