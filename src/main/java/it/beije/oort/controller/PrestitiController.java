package it.beije.oort.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.sb.biblioteca.Prestiti;
import it.beije.oort.sb.jpa.JPDBtools;

@Controller
public class PrestitiController {
	
	@RequestMapping(value = "/Prestiti", method = RequestMethod.GET)
	public String visualizzaprestiti() {				
		return "visualizzaprestiti";
	}
	
	@RequestMapping(value = "/NewPrestito", method = RequestMethod.POST)
	public String newPrestito(Prestiti prestito, Model model, HttpServletRequest request) {
		try {
			prestito.setData_fine(LocalDate.parse(request.getParameter("DataFine")));
		} catch(DateTimeParseException e) {
		}
		try {
			//la data di inizio non deve dare errore
			prestito.setData_inizio(LocalDate.parse(request.getParameter("DataInizio")));
			JPDBtools.insert(prestito, "OortBiblioteca");
			model.addAttribute("messaggio", "Prestito Registrato Correttamente");
			return "menubiblioteca";
		}catch(Exception e) {
			model.addAttribute("messaggio", "Impossibile Registrare Prestito");
			return "menubiblioteca";
		}
	}
	
	@RequestMapping(value = "/NewPrestito", method = RequestMethod.GET)
	public String newPrestitoG() {
		return "newprestito";
	}

}
