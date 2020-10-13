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
public class InserimentoPrestitoController {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PrestitoService prestitoService;
	
	@RequestMapping(value = "/biblioteca/inserimento_prestito", method = RequestMethod.GET)
	public String inserimentoPrestito() {
		String page = "/biblioteca/inserimento_prestito";
		log.debug("Accesso GET alla URL /biblioteca/inserimento_prestito");
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/inserimento_prestito", method = RequestMethod.POST)
	public String inserimentoPrestito(HttpServletRequest request, Model model) {
		String page = "/biblioteca/inserimento_prestito";
		log.debug("Accesso POST alla URL /biblioteca/inserimento_prestito");
    	eseguiForm(request, model);
		return page;
	}

	private void eseguiForm(HttpServletRequest request, Model model) {
		try {
			
		Prestito prestito = prestitoService.crea(
				request.getParameter("idLibro"),
				request.getParameter("idUtente"),
				request.getParameter("dataInizio"),
				request.getParameter("dataFine"),
				request.getParameter("note"));
		
		log.debug("Esecuzione della form, prestito da inserire: " + prestito);
    		prestitoService.inserisci(prestito);
    		model.addAttribute("successoMsg", "Prestito inserito correttamente: " + prestito);
    	} catch (Exception e) {
    		model.addAttribute("erroreMsg", "Il prestito non è stato inserito. " + e.getMessage());
    	}
	}
}
