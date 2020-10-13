package it.beije.oort.madonia.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Editore;
import it.beije.oort.madonia.biblioteca.service.EditoreService;

@Controller

public class ModificaEditoreController {
	
	@Autowired
	private EditoreService editoreService;
	
	@RequestMapping(value = "/biblioteca/modifica_editore", method = RequestMethod.GET)
	public String modificaEditore() {
		String page = "/biblioteca/modifica_editore";
		System.out.println("modifica_editore [GET]...");
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/modifica_editore", method = RequestMethod.POST)
	public String modificaEditore(Editore editore, HttpServletRequest request, Model model) {
		System.out.println("modifica_editore [POST]...");
		String page = "/biblioteca/modifica_editore";
		eseguiForm(editore, request, model);
		return page;
	}

	private void eseguiForm(Editore editore, HttpServletRequest request, Model model) {
		if (( (String) request.getParameter("submit") ).equals("id")) {

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
			
		} else if (( (String) request.getParameter("submit") ).equals("modifica")) {
			
			try {
				editoreService.modifica(editore);
				model.addAttribute("successoMsg", "Editore modificato correttamente. " + editore);
			} catch (Exception e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
				System.out.println("Eccezione!");
				e.printStackTrace();
			}
			
		}
	}
}
