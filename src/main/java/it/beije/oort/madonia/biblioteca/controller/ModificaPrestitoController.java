package it.beije.oort.madonia.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Prestito;
import it.beije.oort.madonia.biblioteca.service.PrestitoService;

@Controller
public class ModificaPrestitoController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PrestitoService prestitoService;
	
	@RequestMapping(value = "/biblioteca/modifica_prestito", method = RequestMethod.GET)
	public String modificaPrestito() {
		String page = "/biblioteca/modifica_prestito";
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/modifica_prestito", method = RequestMethod.POST)
	public String modificaPrestito(HttpServletRequest request, Model model) {
		String page = "/biblioteca/modifica_prestito";
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
				System.out.println("Eccezione!");
				e.printStackTrace();
			} catch (Exception e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
				e.printStackTrace();
			}
			
		} else if ((request.getParameter("submit") ).equals("modifica")) {
			try {
			Prestito prestito = prestitoService.crea(
					request.getParameter("idLibro"),
					request.getParameter("idUtente"),
					request.getParameter("dataInizio"),
					request.getParameter("dataFine"),
					request.getParameter("note"));
			
				prestitoService.modifica(request.getParameter("id"), prestito);
				model.addAttribute("successoMsg", "Prestito modificato correttamente. " + prestito);
			} catch (Exception e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
				e.printStackTrace();
			}
			
		}
	}
}
