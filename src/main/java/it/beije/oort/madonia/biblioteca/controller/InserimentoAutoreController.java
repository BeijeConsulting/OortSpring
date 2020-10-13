package it.beije.oort.madonia.biblioteca.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Autore;
import it.beije.oort.madonia.biblioteca.service.AutoreService;
import it.beije.oort.madonia.biblioteca.utilities.GeneralUtils;
import it.beije.oort.madonia.db.DatabaseManagerBiblioteca;

@Controller
public class InserimentoAutoreController {
	
	@Autowired
	private AutoreService autoreService;
	
	@RequestMapping(value = "/biblioteca/inserimento_autore", method = RequestMethod.GET)
	public String inserimentoAutore() {
		String page = "/biblioteca/inserimento_autore";
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/inserimento_autore", method = RequestMethod.POST)
	public String inserimentoAutore(HttpServletRequest request, Model model) {
		String page = "/biblioteca/inserimento_autore";
    	eseguiForm(request, model);
		return page;
	}

	private void eseguiForm(HttpServletRequest request, Model model) {
		Autore autore = new Autore();
		autore.setNome(request.getParameter("nome"));
		autore.setCognome(request.getParameter("cognome"));
		autore.setBiografia(request.getParameter("biografia"));
		autore.setDataNascita(GeneralUtils.stringToSqlDate(request.getParameter("dataNascita")));
		autore.setDataMorte(GeneralUtils.stringToSqlDate(request.getParameter("dataMorte")));
		
		System.out.println("Autore da inserire: " + autore);
    	
    	try {
    		autoreService.inserisci(autore);
    		model.addAttribute("successoMsg", "Autore inserito correttamente: " + autore);
    	} catch (Exception e) {
    		model.addAttribute("erroreMsg", "L'autore non è stato inserito. " + e.getMessage());
    	}
	}
}
