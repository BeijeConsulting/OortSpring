package it.beije.oort.madonia.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Libro;
import it.beije.oort.madonia.biblioteca.service.LibroService;

@Controller
public class ModificaLibroController {
	
	@Autowired
	private LibroService libroService;
	
	@RequestMapping(value = "/biblioteca/modifica_libro", method = RequestMethod.GET)
	public String modificaLibro() {
		String page = "/biblioteca/modifica_libro";
		System.out.println("modifica_libro [GET]...");
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/modifica_libro", method = RequestMethod.POST)
	public String modificaLibro(Libro libro, HttpServletRequest request, Model model) {
		String page = "/biblioteca/modifica_libro";
		eseguiForm(libro, request, model);
		
		return page;
	}

	private void eseguiForm(Libro libro, HttpServletRequest request, Model model) {
		System.out.println("modifica_libro [POST]...");
		
		if ((request.getParameter("submit") ).equals("id")) {

			try {
				libro = libroService.trova(request.getParameter("idLibro"));
				
				if (libro != null) {
					model.addAttribute("libro", libro);
					model.addAttribute("successoMsg", "Libro trovato");
				} else {
					model.addAttribute("erroreMsg", "Libro non trovato, hai messo una id valida?");
				}
			} catch (NumberFormatException e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: l'id inserito non è un numero");
				System.out.println("Eccezione!");
				e.printStackTrace();
			} catch (Exception e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
				System.out.println("Eccezione!");
				e.printStackTrace();
			}
			
		} else if ((request.getParameter("submit") ).equals("modifica")) {
			
			try {
				libroService.modifica(request.getParameter("id"), libro);
				model.addAttribute("successoMsg", "Libro modificato correttamente. " + libro);
			} catch (Exception e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
				System.out.println("Eccezione!");
				e.printStackTrace();
			}
			
		}
	}
}
