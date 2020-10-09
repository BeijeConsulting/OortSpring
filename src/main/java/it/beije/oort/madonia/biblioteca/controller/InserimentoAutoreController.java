package it.beije.oort.madonia.biblioteca.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Autore;
import it.beije.oort.madonia.biblioteca.ebeans.Utente;
import it.beije.oort.madonia.db.DatabaseManagerBiblioteca;

@Controller
public class InserimentoAutoreController {
	
	@RequestMapping(value = "/biblioteca/inserimento_autore", method = RequestMethod.GET)
	public String inserimentoAutore() {
		String page = "/biblioteca/inserimento_autore";
		
		return page;
	}
	
	@RequestMapping(value = "/biblioteca/inserimento_autore", method = RequestMethod.POST)
	public String inserimentoAutore(HttpServletRequest request, Model model) {
		String page = "/biblioteca/inserimento_autore";
    	
    	String dataNascita = request.getParameter("dataNascita");
		String dataMorte = request.getParameter("dataMorte");
		
		Autore autore = new Autore();
		autore.setNome(request.getParameter("nome"));
		autore.setCognome(request.getParameter("cognome"));
		autore.setBiografia(request.getParameter("biografia"));
		autore.setDataNascita(dataNascita.length() > 0 ? Date.valueOf(dataNascita) : null);
		autore.setDataMorte(dataMorte.length() > 0 ? Date.valueOf(dataMorte) : null);
		
		System.out.println("Autore da inserire: " + autore);
    	
    	try {
    		DatabaseManagerBiblioteca.inserisci(autore);
    		model.addAttribute("successoMsg", "Autore inserito correttamente: " + autore);
    	} catch (Exception e) {
    		model.addAttribute("erroreMsg", "L'autore non � stato inserito. " + e.getMessage());
    	}
    	
		return page;
	}
}
