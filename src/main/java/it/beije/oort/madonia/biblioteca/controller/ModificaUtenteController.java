package it.beije.oort.madonia.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Utente;
import it.beije.oort.madonia.biblioteca.service.UtenteService;

@Controller
public class ModificaUtenteController {
	
	@Autowired
	private UtenteService utenteService;
	
	@RequestMapping(value = "/biblioteca/modifica_utente", method = RequestMethod.GET)
	public String modificaUtente() {
		String page = "/biblioteca/modifica_utente";
		System.out.println("modifica_utente [GET]...");
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/modifica_utente", method = RequestMethod.POST)
	public String modificaUtente(Utente utente, HttpServletRequest request, Model model) {
		String page = "/biblioteca/modifica_utente";
		eseguiForm(utente, request, model);
		
		return page;
	}

	private void eseguiForm(Utente utente, HttpServletRequest request, Model model) {
		System.out.println("modifica_utente [POST]...");
		
		if ((request.getParameter("submit") ).equals("id")) {

			try {
				utente = utenteService.trova(request.getParameter("idUtente"));
				
				if (utente != null) {
					model.addAttribute("utente", utente);
					model.addAttribute("successoMsg", "Utente trovato");
				} else {
					model.addAttribute("erroreMsg", "Utente non trovato, hai messo una id valida?");
				}
			} catch (NumberFormatException e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: l'id inserito non è un numero");
				System.out.println("Eccezione!");
				e.printStackTrace();
			} catch (Exception e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
				System.out.println("Eccezione!");
				e.printStackTrace();
			}
			
		} else if ((request.getParameter("submit") ).equals("modifica")) {
			
			try {
				utenteService.modifica(request.getParameter("id"), utente);
				model.addAttribute("successoMsg", "Utente modificato correttamente. " + utente);
			} catch (Exception e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
				System.out.println("Eccezione!");
				e.printStackTrace();
			}
			
		}
	}
}
