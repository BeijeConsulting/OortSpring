package it.beije.oort.gregori.biblioteca.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.oort.gregori.biblioteca.Utente;
import it.beije.oort.gregori.biblioteca.repository.UtenteRepository;
import it.beije.oort.gregori.biblioteca.service.UtenteService;

@RestController
@RequestMapping(value = "/api")
public class RestUtenteController {
	
	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@RequestMapping(value = "/utenti", method = RequestMethod.GET)
	public List<Utente> getUtenti() {
		List<Utente> utenti = utenteRepository.findAll();
		
		System.out.println("utenti: " + utenti);
		
		return utenti;
	}
	
	@PostMapping("/utenti")
	public Utente utente(@RequestBody Utente utente, HttpServletRequest request, Model model) {
		System.out.println("ricevo dati utente..." + utente);
		
		utenteService.insert(utente);
		
		return utente;
	}
	
	@PutMapping("/utenti/{id}")
	public Utente utente(@RequestBody Utente utente, @PathVariable Integer id, HttpServletRequest request, Model model) {
		System.out.println("ricevo dati utente..." + utente);
		
		if (utente.getId() != null && utente.getId() != id) {
			throw new IllegalArgumentException("ID NON VALIDO!!!");
		}
		
		return utenteService.update(id, utente);
	}

//	
//	@RequestMapping(value = "/utente/inserisci", method = RequestMethod.GET)
//	public String inserisci() {
//		System.out.println("inserisci...");
//		
//		return "utente-inserisci";
//	}
//	
//	@RequestMapping(value = "/utente/inserisci", method = RequestMethod.POST)
//	public String inserisci(Utente utente, Model model) {
//		System.out.println("inserisci post...");
//		
//		utenteService.insert(utente);
//		model.addAttribute("utente", utente);
//		
//		return "utente-inserisci";
//	}
//	
//	@RequestMapping(value = "/utente/modifica", method = RequestMethod.GET)
//	public String modifica(Model model) {
//		System.out.println("modifica...");
//		
//		List<Utente> utenti = utenteService.view();
//		
//		model.addAttribute("utenti", utenti);
//		
//		return "utente-modifica";
//	}
//	
//	@RequestMapping(value = "/utente/modifica", method = RequestMethod.POST)
//	public String modifica(@RequestParam(name = "selezione-tabella") String selezione, Utente utente, Model model) {
//		System.out.println("modifica post...");
//		
//		utenteService.update(Integer.parseInt(selezione), utente);
//		model.addAttribute("utente", utente);
//		
//		return "utente-modifica";
//	}
//	
//	@RequestMapping(value = "/utente/rimuovi", method = RequestMethod.GET)
//	public String rimuovi(Model model) {
//		System.out.println("rimuovi...");
//		
//		return "utente-rimuovi";
//	}
//	
//	@RequestMapping(value = "/utente/ricerca", method = RequestMethod.GET)
//	public String ricerca() {
//		System.out.println("ricerca...");
//		
//		return "utente-ricerca";
//	}
//	
//	@RequestMapping(value = "/utente/ricerca", method = RequestMethod.POST)
//	public String ricerca(@RequestParam(name = "search-value") String searchValue, Model model) {
//		System.out.println("ricerca post...");
//		
//		Utente utente = utenteService.findByEmail(searchValue);
//		
//		model.addAttribute("utente", utente);
//		
//		return "utente-ricerca";
//	}
	
}
