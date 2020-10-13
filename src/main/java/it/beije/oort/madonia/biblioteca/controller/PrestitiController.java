package it.beije.oort.madonia.biblioteca.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Libro;
import it.beije.oort.madonia.biblioteca.ebeans.Prestito;
import it.beije.oort.madonia.biblioteca.ebeans.Utente;
import it.beije.oort.madonia.biblioteca.service.LibroService;
import it.beije.oort.madonia.biblioteca.service.PrestitoService;
import it.beije.oort.madonia.db.DatabaseManagerBiblioteca;

@Controller
public class PrestitiController {
	
	@Autowired
	private PrestitoService prestitoService;
	
	@Autowired
	private LibroService libroService;
	
	@RequestMapping(value = "/biblioteca/prestiti", method = RequestMethod.GET)
	public String prestiti(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		System.out.println("prestiti [GET]...");
		
		String page = "";
		Utente utenteAttivo = (Utente) request.getSession().getAttribute("utenteAttivo");
    	if (utenteAttivo == null || utenteAttivo.getId() == 0) {
    		request.getSession().setAttribute("errore", "Devi effettuare il login prima di accedere ai contenuti.");
    		page = "/biblioteca/login";
    		response.sendRedirect("./login");
    	} else {
    		List<Prestito> listaPrestiti = prestitoService.trovaPerIdUtente(utenteAttivo.getId());
    		Map<Integer, String> mappaTitoli = libroService.generaMappaTitoli(listaPrestiti);
    		model.addAttribute("listaPrestiti", listaPrestiti);
    		model.addAttribute("mappaTitoli", mappaTitoli);
    		page = "/biblioteca/prestiti";
    	}
		
		return page;
	}
	
}
