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
public class InserimentoEditoreController {
	
	@Autowired
	private EditoreService editoreService;
	
	@RequestMapping(value = "/biblioteca/inserimento_editore", method = RequestMethod.GET)
	public String inserimentoEditore() {
		String page = "/biblioteca/inserimento_editore";
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/inserimento_editore", method = RequestMethod.POST)
	public String inserimentoEditore(Editore editore, HttpServletRequest request, Model model) {
		String page = "/biblioteca/inserimento_editore";
    	eseguiForm(editore, request, model);
		return page;
	}

	private void eseguiForm(Editore editore, HttpServletRequest request, Model model) {
		System.out.println("Editore da inserire: " + editore);
    	
    	try {
    		editoreService.inserisci(editore);
    		model.addAttribute("successoMsg", "Editore inserito correttamente: " + editore);
    	} catch (Exception e) {
    		model.addAttribute("erroreMsg", "L'editore non è stato inserito. " + e.getMessage());
    	}
	}
}
