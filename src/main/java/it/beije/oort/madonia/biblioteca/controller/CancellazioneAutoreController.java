package it.beije.oort.madonia.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Autore;
import it.beije.oort.madonia.biblioteca.service.AutoreService;
import it.beije.oort.madonia.db.DatabaseManagerBiblioteca;

@Controller
public class CancellazioneAutoreController {

	@Autowired
	private AutoreService autoreService;

	@RequestMapping(value = "/biblioteca/cancellazione_autore", method = RequestMethod.GET)
	public String cancellaAutore() {
		String page = "/biblioteca/cancellazione_autore";
		System.out.println("cancellazione_autore [GET]...");
		return page;
	}

	@RequestMapping(value = "/biblioteca/cancellazione_autore", method = RequestMethod.POST)
	public String cancellaAutore(HttpServletRequest request, Model model) {
		String page = "/biblioteca/cancellazione_autore";
		System.out.println("cancellazione_autore [POST]...");
		eseguiForm(request, model);
		return page;
	}

	private void eseguiForm(HttpServletRequest request, Model model) {
		if (( request.getParameter("submit") ).equals("id")) {
			try {
				Autore autore = autoreService.trova(request.getParameter("idAutore"));

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

		} else if (( request.getParameter("submit") ).equals("cancellazione")) {

			try {
				autoreService.cancella(request.getParameter("id"));
				model.addAttribute("successoMsg", "Autore cancellato correttamente.");
			} catch (Exception e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
				System.out.println("Eccezione!");
				e.printStackTrace();
			}

		}
	}
}
