package it.beije.oort.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import it.beije.oort.sb.biblioteca.Prestiti;
import it.beije.oort.sb.biblioteca.Utenti;
import it.beije.oort.sb.jpa.JPDBtools;
import it.beije.oort.service.PrestitiService;

@Controller
public class PrestitiController {
	@Autowired
	private PrestitiService prestitiService;
	
	@RequestMapping(value = "/Prestiti", method = RequestMethod.GET)
	public String visualizzaprestiti(HttpServletRequest request, Model model) {
		HttpSession session= request.getSession();
		Utenti utente = (Utenti)session.getAttribute("utente");
		List<Prestiti> list = JPDBtools.ricercaPrestitiId("utente",utente.getId());
		model.addAttribute("lista", list);
		return "visualizzaprestiti";
	}
	
	@RequestMapping(value = "/NewPrestito", method = RequestMethod.POST)
	public String newPrestito(Prestiti prestito, Model model, HttpServletRequest request) {	
	model.addAttribute("messaggio", prestitiService.newPrestitoService(request.getParameter("DataInizio"), request.getParameter("DataFine"), prestito));
	return "menubiblioteca";
	}
	
	@RequestMapping(value = "/NewPrestito", method = RequestMethod.GET)
	public String newPrestitoG() {
		return "newprestito";
	}

}
