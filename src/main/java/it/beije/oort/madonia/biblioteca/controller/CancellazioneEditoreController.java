package it.beije.oort.madonia.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Editore;
import it.beije.oort.madonia.biblioteca.service.EditoreService;
import it.beije.oort.madonia.db.DatabaseManagerBiblioteca;

@Controller
public class CancellazioneEditoreController {
	
	@Autowired
	private EditoreService editoreService;
	
	@RequestMapping(value = "/biblioteca/cancellazione_editore", method = RequestMethod.GET)
	public String cancellaEditore() {
		String page = "/biblioteca/cancellazione_editore";
		System.out.println("cancellazione_editore [GET]...");
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/cancellazione_editore", method = RequestMethod.POST)
	public String cancellaEditore(HttpServletRequest request, Model model) {
		String page = "/biblioteca/cancellazione_editore";
		eseguiForm(request, model);
		return page;
	}

	private void eseguiForm(HttpServletRequest request, Model model) {
		System.out.println("cancellazione_editore [POST]...");
		
		if (( (String) request.getParameter("submit") ).equals("id")) {

			Editore editore;
			try {
				editore = editoreService.trova((String) request.getParameter("idEditore"));
				
				if (editore != null) {
					model.addAttribute("editore", editore);
					model.addAttribute("successoMsg", "Editore trovato");
				} else {
					model.addAttribute("erroreMsg", "Editore non trovato, hai messo una id valida?");
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
			
		} else if (( (String) request.getParameter("submit") ).equals("cancellazione")) {
			
			try {
				editoreService.cancella(request.getParameter("id"));
				model.addAttribute("successoMsg", "Editore cancellato correttamente.");
			} catch (Exception e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
				System.out.println("Eccezione!");
				e.printStackTrace();
			}
			
		}
	}
}
