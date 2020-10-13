package it.beije.oort.madonia.biblioteca.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Autore;
import it.beije.oort.madonia.biblioteca.service.AutoreService;
import it.beije.oort.madonia.biblioteca.utilities.GeneralUtils;

@Controller
public class ModificaAutoreController {
	
	@Autowired
	private AutoreService autoreService;
	
	@RequestMapping(value = "/biblioteca/modifica_autore", method = RequestMethod.GET)
	public String modificaAutore() {
		String page = "/biblioteca/modifica_autore";
		System.out.println("modifica_autore [GET]...");
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/modifica_autore", method = RequestMethod.POST)
	public String modificaAutore(HttpServletRequest request, Model model) {
		String page = "/biblioteca/modifica_autore";
		eseguiForm(request, model);
		
		return page;
	}

	private void eseguiForm(HttpServletRequest request, Model model) {
		System.out.println("modifica_autore [POST]...");
		
		if ((request.getParameter("submit") ).equals("id")) {
			try {
				Autore autore = autoreService.trova(request.getParameter("idAutore"));
				
				if (autore != null) {
					model.addAttribute("autore", autore);
					model.addAttribute("successoMsg", "Autore trovato");
				} else {
					model.addAttribute("erroreMsg", "Autore non trovato, hai messo una id valida?");
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
				Autore autore = new Autore();
				autore.setNome(request.getParameter("nome"));
				autore.setCognome(request.getParameter("cognome"));
				autore.setBiografia(request.getParameter("biografia"));
				autore.setDataNascita(GeneralUtils.stringToSqlDate(request.getParameter("dataNascita")));
				autore.setDataMorte(GeneralUtils.stringToSqlDate(request.getParameter("dataMorte")));
				
				autoreService.modifica(request.getParameter("id"), autore);
				model.addAttribute("successoMsg", "Autore modificato correttamente. " + autore);
			} catch (Exception e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
				System.out.println("Eccezione!");
				e.printStackTrace();
			}
			
		}
	}
}
