package it.beije.oort.madonia.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Autore;
import it.beije.oort.madonia.db.DatabaseManagerBiblioteca;

@Controller
public class ModificaAutoreController {
	
	@RequestMapping(value = "/biblioteca/modifica_autore", method = RequestMethod.GET)
	public String modificaAutore() {
		String page = "/biblioteca/modifica_autore";
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/modifica_autore", method = RequestMethod.POST)
	public String modificaAutore(HttpServletRequest request, Model model) {
		String page = "/biblioteca/modifica_autore";
		System.out.println("modifica_autore [POST]...");
		
		Autore autore;
		try {
			System.out.println("Input utente -> " + (String) request.getParameter("idAutore"));
			Integer id = Integer.parseInt((String) request.getParameter("idAutore"));
			System.out.println("ID trovato: " + id);
			autore = DatabaseManagerBiblioteca.trovaAutore(id);
			System.out.println("Autore trovato: " + autore);
			if (autore != null) {
				model.addAttribute("autore", autore);
			}
		} catch (NumberFormatException e) {
			model.addAttribute("erroreMsg", "Operazione non eseguita: l'id inserito non è un numero");
			System.out.println("Eccezione!");
			e.printStackTrace();
		}catch (Exception e) {
			model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
			System.out.println("Eccezione!");
			e.printStackTrace();
		}
		
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/modifica_autore/{id}", method = RequestMethod.GET)
	public String modificaAutore(@PathVariable Integer id, HttpServletRequest request, Model model) {
		String page = "/biblioteca/modifica_autore";
		
		Autore autore;
		try {
			autore = DatabaseManagerBiblioteca.trovaAutore(id);
			if (autore != null) {
				model.addAttribute("autore", autore);
			}
		} catch (Exception e) {
			model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
		}
		
		return page;
	}
	
}
