package it.beije.oort.madonia.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Autore;
import it.beije.oort.madonia.db.DatabaseManagerBiblioteca;

@Controller
public class CancellazioneAutoreController {
	
	@RequestMapping(value = "/biblioteca/cancellazione_autore", method = RequestMethod.GET)
	public String cancellaAutore() {
		String page = "/biblioteca/cancellazione_autore";
		System.out.println("cancellazione_autore [GET]...");
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/cancellazione_autore", method = RequestMethod.POST)
	public String cancellaAutore(HttpServletRequest request, Model model) {
		String page = "/biblioteca/cancellazione_autore";
		eseguiForm(request, model);
		return page;
	}

	private void eseguiForm(HttpServletRequest request, Model model) {
		System.out.println("cancellazione_autore [POST]...");
		
		if (( (String) request.getParameter("submit") ).equals("id")) {

			Autore autore;
			try {
				System.out.println("Input utente -> " + (String) request.getParameter("idAutore"));
				Integer id = Integer.parseInt((String) request.getParameter("idAutore"));
				System.out.println("ID trovato: " + id);
				autore = DatabaseManagerBiblioteca.trovaAutore(id);
				System.out.println("Autore trovato: " + autore);
				
				if (autore != null) {
					model.addAttribute("autore", autore);
					model.addAttribute("successoMsg", "Autore trovato");
				} else {
					model.addAttribute("erroreMsg", "Autore non trovato, hai messo una id valida?");
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
			
		} else if (( (String) request.getParameter("submit") ).equals("cancellazione")) {
			
			try {
				Integer id = Integer.valueOf(request.getParameter("id"));
				System.out.println("Cancellazione autore in corso.");
				DatabaseManagerBiblioteca.cancellaAutore(id);
				System.out.println("Cancellazione eseguita");
				model.addAttribute("successoMsg", "Autore cancellato correttamente.");
			} catch (Exception e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
				System.out.println("Eccezione!");
				e.printStackTrace();
			}
			
		}
	}
}
