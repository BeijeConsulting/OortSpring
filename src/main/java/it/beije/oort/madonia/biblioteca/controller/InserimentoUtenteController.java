package it.beije.oort.madonia.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Utente;
import it.beije.oort.madonia.biblioteca.service.UtenteService;

@Controller
public class InserimentoUtenteController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UtenteService utenteService;
	
	@RequestMapping(value = "/biblioteca/inserimento_utente", method = RequestMethod.GET)
	public String inserimentoUtente() {
		String page = "/biblioteca/inserimento_utente";
		log.debug("Accesso GET alla URL /biblioteca/inserimento_utente");
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/inserimento_utente", method = RequestMethod.POST)
	public String inserimentoUtente(Utente utente, HttpServletRequest request, Model model) {
		String page = "/biblioteca/inserimento_utente";
		log.debug("Accesso POST alla URL /biblioteca/inserimento_utente");
    	eseguiForm(utente, request, model);
		return page;
	}

	private void eseguiForm(Utente utente, HttpServletRequest request, Model model) {
		log.debug("Esecuzione della form, utente da inserire: " + utente);
    	
    	try {
    		utenteService.inserisci(utente);
    		model.addAttribute("successoMsg", "Utente inserito correttamente: " + utente);
    	} catch (Exception e) {
    		model.addAttribute("erroreMsg", "L'utente non è stato inserito. " + e.getMessage());
    	}
	}
}
