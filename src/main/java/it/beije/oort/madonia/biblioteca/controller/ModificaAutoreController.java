package it.beije.oort.madonia.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ModificaAutoreController {
	
	@RequestMapping(value = "/biblioteca/modifica_autore", method = RequestMethod.GET)
	public String modificaAutore() {
		String page = "/biblioteca/modifica_autore";
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/modifica_autore/{id}", method = RequestMethod.GET)
	public String modificaAutore(Integer id, HttpServletRequest request, Model model) {
		String page = "/biblioteca/modifica_autore";
		
		
		return page;
	}
	
}
