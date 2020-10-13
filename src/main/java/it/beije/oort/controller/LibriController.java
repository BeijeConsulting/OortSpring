package it.beije.oort.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.oort.sb.biblioteca.Autori;
import it.beije.oort.sb.biblioteca.Editori;
import it.beije.oort.sb.biblioteca.Libri;
import it.beije.oort.service.AutoriService;
import it.beije.oort.service.EditoriService;
import it.beije.oort.service.LibriService;

@Controller
public class LibriController {
	
	@Autowired
	private LibriService libriService;
	
	@Autowired
	private AutoriService autoriService;

	@Autowired
	private EditoriService editoriService;
	
	@RequestMapping(value = "/catalogo", method = RequestMethod.GET)
	public String catalogoG(Model model, HttpServletRequest request) {
		request.getSession().setAttribute("richiestaCatalogo", "on");
		return "catalogo";
	}
	
	@RequestMapping(value = "/catalogo", method = RequestMethod.POST)
	public String catalogoP(HttpServletRequest request, Model model, @RequestParam String autore, @RequestParam String editore) {			
		HttpSession session = request.getSession();
		List<Libri> catalogo;		
		List<Autori> autori = new ArrayList<Autori>();
		List<Editori> editori = new ArrayList<Editori>();
		try {
			catalogo = libriService.catalogo(autore, editore);
			for(Libri l : catalogo) {
				autori.add(autoriService.loadById(l.getAutore()));
				editori.add(editoriService.loadById(l.getEditore()));
			}
			model.addAttribute("autori", autori);
			model.addAttribute("editori", editori);
			model.addAttribute("catalogo", catalogo);
			model.addAttribute("availability", libriService.availability(catalogo));
			session.setAttribute("richiestaCatalogo", "off");
//			session.setAttribute("catalogo", catalogo);
		} catch(Exception e) {
			session.setAttribute("richiestaCatalogo", "on");
			model.addAttribute("errore", "Valori Ricerca Errati");
		}
		return "catalogo";
	}
}
