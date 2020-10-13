package it.beije.oort.madonia.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Libro;
import it.beije.oort.madonia.biblioteca.service.LibroService;

@Controller
public class InserimentoLibroController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LibroService libroService;
	
	@RequestMapping(value = "/biblioteca/inserimento_libro", method = RequestMethod.GET)
	public String inserimentoLibro() {
		String page = "/biblioteca/inserimento_libro";
		log.debug("Accesso GET alla URL /biblioteca/inserimento_libro");
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/inserimento_libro", method = RequestMethod.POST)
	public String inserimentoLibro(Libro libro, HttpServletRequest request, Model model) {
		String page = "/biblioteca/inserimento_libro";
		log.debug("Accesso POST alla URL /biblioteca/inserimento_libro");
    	eseguiForm(libro, request, model);
		return page;
	}

	private void eseguiForm(Libro libro, HttpServletRequest request, Model model) {
		log.debug("Esecuzione della form, libro da inserire: " + libro);
    	
    	try {
    		libroService.inserisci(libro);
    		model.addAttribute("successoMsg", "Libro inserito correttamente: " + libro);
    	} catch (Exception e) {
    		model.addAttribute("erroreMsg", "Il libro non è stato inserito. " + e.getMessage());
    	}
	}
}
