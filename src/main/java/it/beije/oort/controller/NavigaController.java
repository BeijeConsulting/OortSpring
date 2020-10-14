package it.beije.oort.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.entity.Libro;
import it.beije.oort.service.LibroService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class NavigaController {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LibroService libroService;
	
	//insert
//	utenteRepository.save(utente);
	//update
//	utenteService.update(id, utente);
	
	@RequestMapping(value = "/biblioteca/libro_titolo", method = RequestMethod.GET)
	public String titoli(HttpServletRequest request, Model model) {
		List<Libro> titoli = new ArrayList<>();
		log.info("get");

		model.addAttribute("errore", "");	
		request.getSession().setAttribute("titoli", (ArrayList)titoli);
		return "biblioteca/libro_titolo";
	}
	
	@RequestMapping(value = "/biblioteca/libro_titolo", method = RequestMethod.POST)
	public String titoli(HttpServletRequest request, String titolo, Model model) {
		log.info("post");
		List<Libro> titoli = new ArrayList<>();
		model.addAttribute("errore", "Nessun libro corrisponde al Titolo inserito.");	

		if (!titolo.contentEquals("")) {
			titoli = libroService.cercaTitolo(titolo);
			log.info(titoli.toString());
			if (titoli.size() != 0)
				model.addAttribute("errore", "");	
		}
		request.getSession().setAttribute("titoli", (ArrayList)titoli);
		return "biblioteca/libro_titolo";
	}
	
	
	@RequestMapping(value = "/biblioteca/visualizza_catalogo", method = RequestMethod.GET)
	public String catalogo(HttpServletRequest request, HttpServletResponse response) {

		List<Libro> catalogo = libroService.catalogoLibro(); 
		
		request.getSession().setAttribute("catalogo", (ArrayList)catalogo);
		return "biblioteca/visualizza_catalogo";
	}
	
	
	@RequestMapping(value = "/biblioteca/libro_id", method = RequestMethod.GET)
	public String libroId(HttpServletRequest request, HttpServletResponse response,
						 String stringId, Model model) {
		Libro libro = null;
		log.info(stringId);

		
		request.getSession().setAttribute("libro", libro);
		model.addAttribute("libro", libro);
		if (stringId == null || stringId.equals("")) {
			log.info("null");


			model.addAttribute("errore", "");	
			return "biblioteca/libro_id";
		} else {
			try {
				log.info("try");


				int id = Integer.parseInt(stringId);			
				//SELECT
				libro =  libroService.libroId(id);
				
				if (libro == null) {
					model.addAttribute("errore", "L'id non corrisponde a nessun libro");	
					return "biblioteca/libro_id";
				}
				log.info(libro.toString());

				
				request.getSession().setAttribute("libro", libro);
				model.addAttribute("libro", libro);
				return "biblioteca/libro_id";
			} catch (NumberFormatException nfe) {
				model.addAttribute("errore", "L'id inserito non è valido");	
				return "biblioteca/libro_id";
			}
		}
	}
}