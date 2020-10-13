package it.beije.oort.madonia.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Prestito;
import it.beije.oort.madonia.biblioteca.service.PrestitoService;

@Controller
public class CancellazionePrestitoController {
	
	@Autowired
	private PrestitoService prestitoService;
	
	@RequestMapping(value = "/biblioteca/cancellazione_prestito", method = RequestMethod.GET)
	public String cancellaPrestito() {
		String page = "/biblioteca/cancellazione_prestito";
		System.out.println("cancellazione_prestito [GET]...");
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/cancellazione_prestito", method = RequestMethod.POST)
	public String cancellaPrestito(HttpServletRequest request, Model model) {
		String page = "/biblioteca/cancellazione_prestito";
		eseguiForm(request, model);
		return page;
	}

	private void eseguiForm(HttpServletRequest request, Model model) {
		if ((request.getParameter("submit") ).equals("id")) {
			try {
				Prestito prestito = prestitoService.trova(request.getParameter("idPrestito"));
				
				if (prestito != null) {
					model.addAttribute("prestito", prestito);
					model.addAttribute("successoMsg", "Prestito trovato");
				} else {
					model.addAttribute("erroreMsg", "Prestito non trovato, hai messo una id valida?");
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
				prestitoService.cancella(request.getParameter("id"));
				model.addAttribute("successoMsg", "Prestito cancellato correttamente.");
			} catch (Exception e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
}
