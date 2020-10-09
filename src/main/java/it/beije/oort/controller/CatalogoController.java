package it.beije.oort.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.sb.biblioteca.Libri;
import it.beije.oort.sb.jpa.JPDBtools;

@Controller
public class CatalogoController {
	
	


	@RequestMapping(value = "/CatalogoAutori", method = RequestMethod.GET)
	public String catalogoAutori(Model model) {	
		model.addAttribute("autori", JPDBtools.catalogoAutori());
		return "autori";
	}
	
	@RequestMapping(value = "/CatalogoUtenti", method = RequestMethod.GET)
	public String catalogoUtenti(Model model) {	
		model.addAttribute("utenti", JPDBtools.catalogoUtenti());
		return "utenti";
	}
	
	@RequestMapping(value = "/CatalogoEditori", method = RequestMethod.GET)
	public String catalogoEditori(Model model) {	
		model.addAttribute("editori", JPDBtools.catalogoEditori());
		return "editori";
	}

	@RequestMapping(value = "/Catalogo", method = RequestMethod.GET)
	public String catalogoG(Model model, HttpServletRequest request) {
		request.getSession().setAttribute("richiestaCatalogo", "on");
		return "catalogo";
	}
	
	@RequestMapping(value = "/Catalogo", method = RequestMethod.POST)
	public String catalogoP(HttpServletRequest request, Model model) {	
		HttpSession session = request.getSession();
		String autore = request.getParameter("Autore");
		String editore = request.getParameter("Editore");
		List<Libri> catalogo;		
		if(autore.equals(editore) && autore.equals("0")){ 			
		catalogo = JPDBtools.catalogoLibri();
		} else { 
				try {
						catalogo = JPDBtools.catalogoLibriPersonalizzato(Integer.parseInt(autore), Integer.parseInt(editore));
			} 	catch(Exception e) {
				session.setAttribute("richiestaCatalogo", "on");
				model.addAttribute("errore", "Valori Ricerca Errati");
				return "catalogo";
			}
		}
		session.setAttribute("richiestaCatalogo", "off");
		session.setAttribute("catalogo", catalogo);
		return "catalogo";
	}
}
