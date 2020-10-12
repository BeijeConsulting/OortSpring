package it.beije.oort.madonia.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Libro;
import it.beije.oort.madonia.db.DatabaseManagerBiblioteca;

@Controller
public class ModificaLibroController {
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
		
		if (( (String) request.getParameter("submit") ).equals("id")) {

			try {
				System.out.println("Input utente -> " + (String) request.getParameter("idLibro"));
				Integer id = Integer.parseInt((String) request.getParameter("idLibro"));
				System.out.println("ID trovato: " + id);
				libro = DatabaseManagerBiblioteca.trovaLibro(id);
				System.out.println("Libro trovato: " + libro);
				
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
			
		} else if (( (String) request.getParameter("submit") ).equals("modifica")) {
			
			try {
				System.out.println("Modifica libro in corso: " + libro);
				DatabaseManagerBiblioteca.modifica(libro);
				System.out.println("Modifica eseguita");
				model.addAttribute("successoMsg", "Libro modificato correttamente. " + libro);
			} catch (Exception e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
				System.out.println("Eccezione!");
				e.printStackTrace();
			}
			
		}
	}
}
