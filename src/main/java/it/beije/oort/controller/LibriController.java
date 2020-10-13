package it.beije.oort.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.oort.sb.biblioteca.Libri;
import it.beije.oort.sb.jpa.JPDBtools;
import it.beije.oort.service.LibriService;

@Controller
public class LibriController {
	
	@Autowired
	private LibriService libriService;

	@RequestMapping(value = "/Catalogo", method = RequestMethod.GET)
	public String catalogoG(Model model, HttpServletRequest request) {
		request.getSession().setAttribute("richiestaCatalogo", "on");
		return "catalogo";
	}
	
	@RequestMapping(value = "/Catalogo", method = RequestMethod.POST)
	public String catalogoP(HttpServletRequest request, Model model, @RequestParam String autore, @RequestParam String editore) {			
		HttpSession session = request.getSession();
		List<Libri> catalogo;		
		try {
			catalogo = libriService.catalogo(autore, editore);
			session.setAttribute("richiestaCatalogo", "off");
			session.setAttribute("catalogo", catalogo);
		} catch(Exception e) {
			session.setAttribute("richiestaCatalogo", "on");
			model.addAttribute("errore", "Valori Ricerca Errati");
		}
		return "catalogo";
	}
}
