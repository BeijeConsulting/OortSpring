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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import it.beije.oort.sb.biblioteca.Libri;
import it.beije.oort.sb.biblioteca.Prestiti;
import it.beije.oort.sb.biblioteca.Utenti;
import it.beije.oort.sb.jpa.JPDBtools;
import it.beije.oort.service.LibriService;
import it.beije.oort.service.PrestitiService;
import it.beije.oort.service.UtentiService;

@Controller
public class PrestitiController {
	@Autowired
	private PrestitiService prestitiService;
	@Autowired
	private LibriService libriService;
	@Autowired
	private UtentiService utentiService;
	
	@RequestMapping(value = "/prestitipersonali", method = RequestMethod.GET)
	public String visualizzaprestiti(HttpServletRequest request, Model model) {
		HttpSession session= request.getSession();
		Utenti utente = (Utenti)session.getAttribute("utente");
		List<Prestiti> prestiti = prestitiService.loadByUtente(utente.getId());
		List<Libri> libri = new ArrayList<Libri>();		
		for(Prestiti p : prestiti) {
			libri.add(libriService.loadById(p.getLibro()));
		}
		model.addAttribute("prestiti", prestiti);
		model.addAttribute("libri", libri);
		return "prestitipersonali";
	}
	
	@RequestMapping(value = "/newprestito", method = RequestMethod.POST)
	public String newPrestito(Prestiti prestito, Model model, HttpServletRequest request) {	
	model.addAttribute("messaggio", prestitiService.insert(request.getParameter("dataInizio"), request.getParameter("dataFine"), prestito));
	return "menubiblioteca";
	}
	
	@RequestMapping(value = "/newprestito", method = RequestMethod.GET)
	public String newPrestitoG() {
		return "newprestito";
	}
	@RequestMapping(value="/prestiti", method = RequestMethod.GET)
	public String prestiti(Model model) {
		List<Prestiti> prestiti = prestitiService.load();
		List<Libri> libri = new ArrayList<Libri>();		
		List<Utenti> utenti = new ArrayList<Utenti>();
		for(Prestiti p : prestiti) {
			libri.add(libriService.loadById(p.getLibro()));
			utenti.add(utentiService.loadById(p.getUtente()));
		}
		model.addAttribute("prestiti", prestiti);
		model.addAttribute("utenti", utenti);
		model.addAttribute("libri", libri);
		return "prestiti";
		
	}
	
	@RequestMapping(value = "/deleteprestito", method = RequestMethod.GET)
	public String deleteprestitoG() {
		return "deleteprestito";
	}

	@RequestMapping(value = "/deleteprestito", method = RequestMethod.POST)
	public String deleteprestitoP(@RequestParam String id, Model model) {
		try {
			int indice = Integer.parseInt(id);
			prestitiService.deleteById(indice);
			model.addAttribute("messaggio", "Prestito Cancellato Correttamente");
		} catch(NumberFormatException e) {
			model.addAttribute("messaggio", "Valore Id Prestito Errato");
			return "deleteprestito";
		} catch(Exception e) {
			model.addAttribute("messaggio", "Impossibile Cancellare Prestito");
		}	
		return "menubiblioteca";
	}

}
