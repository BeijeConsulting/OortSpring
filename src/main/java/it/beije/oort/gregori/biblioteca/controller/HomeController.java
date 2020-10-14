
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
		
		return "tabelle";
	}
	
	@RequestMapping(value = "/utente", method = RequestMethod.GET)
	public String utente(Model model) {
		System.out.println("utente...");
		
		model.addAttribute("path", "./utente");
		
		return "home";
	}
	
	@RequestMapping(value = "/autore", method = RequestMethod.GET)
	public String autore(Model model) {
		System.out.println("autore...");
		
		model.addAttribute("path", "/autore");
		
		return "home";
	}
	
	@RequestMapping(value = "/libro", method = RequestMethod.GET)
	public String libro() {
		System.out.println("libro...");
		
		return "home";
	}
	
	@RequestMapping(value = "/prestito", method = RequestMethod.GET)
	public String prestito() {
		System.out.println("prestito...");
		
		return "home";
	}
	
	@RequestMapping(value = "/editore", method = RequestMethod.GET)
	public String editore() {
		System.out.println("editore...");
		
		return "home";
	}
}
