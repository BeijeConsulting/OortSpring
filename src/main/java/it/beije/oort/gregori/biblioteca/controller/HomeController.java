
package it.beije.oort.gregori.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		System.out.println("home...");
		
		return "home";
	}
	
	@RequestMapping(value = "/visualizza", method = RequestMethod.GET)
	public String visualizza(Model model) {
		System.out.println("visualizza...");
		
		return "visualizza";
	}
	
	@RequestMapping(value = "/inserisci", method = RequestMethod.GET)
	public String inserisci() {
		System.out.println("inserisci...");
		
		return "inserisci";
	}
	
	@RequestMapping(value = "/modifica", method = RequestMethod.GET)
	public String modifica(Model model) {
		System.out.println("modifica...");
		
		return "modifica";
	}
	
	@RequestMapping(value = "/rimuovi", method = RequestMethod.GET)
	public String rimuovi(Model model) {
		System.out.println("rimuovi...");
		
		return "rimuovi";
	}
	
	
	@RequestMapping(value = "/ricerca", method = RequestMethod.GET)
	public String ricerca() {
		System.out.println("ricerca...");
		
		return "ricerca";
	}
	
//	@RequestMapping(value = "/utente", method = RequestMethod.GET)
//	public String utente() {
//		System.out.println("utente...");
//		
//		return "home";
//	}
//	
//	@RequestMapping(value = "/autore", method = RequestMethod.GET)
//	public String autore() {
//		System.out.println("autore...");
//		
//		return "home";
//	}
//	
//	@RequestMapping(value = "/libro", method = RequestMethod.GET)
//	public String libro() {
//		System.out.println("libro...");
//		
//		return "home";
//	}
//	
//	@RequestMapping(value = "/prestito", method = RequestMethod.GET)
//	public String prestito() {
//		System.out.println("prestito...");
//		
//		return "home";
//	}
//	
//	@RequestMapping(value = "/editore", method = RequestMethod.GET)
//	public String editore() {
//		System.out.println("editore...");
//		
//		return "home";
//	}
}
