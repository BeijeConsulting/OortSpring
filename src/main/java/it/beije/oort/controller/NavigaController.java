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

@Controller
public class NavigaController {

	@Autowired
	private LibroService libroService;

	
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
		System.out.println(stringId);
		
		request.getSession().setAttribute("libro", libro);
		model.addAttribute("libro", libro);
		if (stringId == null || stringId.equals("")) {
			System.out.println("null");

			model.addAttribute("errore", "");	
			return "biblioteca/libro_id";
		} else {
			try {
				System.out.println("try");

				int id = Integer.parseInt(stringId);			
				//SELECT
				libro =  libroService.libroId(id);
				
				if (libro == null) {
					model.addAttribute("errore", "L'id non corrisponde a nessun libro");	
					return "biblioteca/libro_id";
				}
				System.out.println(libro);
				
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