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
public class CancellazioneLibroController {
	
	@Autowired
	private LibroService libroService;
	
	@RequestMapping(value = "/biblioteca/cancellazione_libro", method = RequestMethod.GET)
	public String cancellaLibro() {
		String page = "/biblioteca/cancellazione_libro";
		System.out.println("cancellazione_libro [GET]...");
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/cancellazione_libro", method = RequestMethod.POST)
	public String cancellaLibro(HttpServletRequest request, Model model) {
		String page = "/biblioteca/cancellazione_libro";
		eseguiForm(request, model);
		return page;
	}

	private void eseguiForm(HttpServletRequest request, Model model) {
		System.out.println("cancellazione_libro [POST]...");
		
		if ((request.getParameter("submit") ).equals("id")) {
			try {
				Libro libro = libroService.trova(request.getParameter("idLibro"));
				
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
			
		} else if ((request.getParameter("submit") ).equals("cancellazione")) {
			
			try {
				libroService.cancella(request.getParameter("id"));
				model.addAttribute("successoMsg", "Libro cancellato correttamente.");
			} catch (Exception e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
				System.out.println("Eccezione!");
				e.printStackTrace();
			}
		}
	}
}
