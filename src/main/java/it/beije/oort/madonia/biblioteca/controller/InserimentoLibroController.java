package it.beije.oort.madonia.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Libro;
import it.beije.oort.madonia.db.DatabaseManagerBiblioteca;

@Controller
public class InserimentoLibroController {
	@RequestMapping(value = "/biblioteca/inserimento_libro", method = RequestMethod.GET)
	public String inserimentoLibro() {
		String page = "/biblioteca/inserimento_libro";
		
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/inserimento_libro", method = RequestMethod.POST)
	public String inserimentoLibro(Libro libro, HttpServletRequest request, Model model) {
		String page = "/biblioteca/inserimento_libro";
    	eseguiForm(libro, request, model);
		return page;
	}

	private void eseguiForm(Libro libro, HttpServletRequest request, Model model) {
		System.out.println("Libro da inserire: " + libro);
    	
    	try {
    		DatabaseManagerBiblioteca.inserisci(libro);
    		model.addAttribute("successoMsg", "Libro inserito correttamente: " + libro);
    	} catch (Exception e) {
    		model.addAttribute("erroreMsg", "Il libro non è stato inserito. " + e.getMessage());
    	}
	}
}
