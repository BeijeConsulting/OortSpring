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
public class CancellazioneUtenteController {
	
	@Autowired
	private UtenteService utenteService;
	
	@RequestMapping(value = "/biblioteca/cancellazione_utente", method = RequestMethod.GET)
	public String cancellaUtente() {
		String page = "/biblioteca/cancellazione_utente";
		System.out.println("cancellazione_utente [GET]...");
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/cancellazione_utente", method = RequestMethod.POST)
	public String cancellaUtente(HttpServletRequest request, Model model) {
		String page = "/biblioteca/cancellazione_utente";
		eseguiForm(request, model);
		return page;
	}

	private void eseguiForm(HttpServletRequest request, Model model) {
		if ((request.getParameter("submit") ).equals("id")) {
			try {
				Utente utente = utenteService.trova(request.getParameter("idUtente"));
				
				if (utente != null) {
					model.addAttribute("utente", utente);
					model.addAttribute("successoMsg", "Utente trovato");
				} else {
					model.addAttribute("erroreMsg", "Utente non trovato, hai messo una id valida?");
				}
			} catch (NumberFormatException e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: l'id inserito non è un numero");
				e.printStackTrace();
			} catch (Exception e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
				e.printStackTrace();
			}
			
		} else if ((request.getParameter("submit") ).equals("cancellazione")) {
			
			try {
				utenteService.cancella(request.getParameter("id"));
				model.addAttribute("successoMsg", "Utente cancellato correttamente.");
			} catch (Exception e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
