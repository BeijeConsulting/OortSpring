package it.beije.oort.madonia.biblioteca.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Autore;
import it.beije.oort.madonia.db.DatabaseManagerBiblioteca;

@Controller
public class ModificaAutoreController {
	
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
		
		if (( (String) request.getParameter("submit") ).equals("id")) {

			Autore autore;
			try {
				System.out.println("Input utente -> " + (String) request.getParameter("idAutore"));
				Integer id = Integer.parseInt((String) request.getParameter("idAutore"));
				System.out.println("ID trovato: " + id);
				autore = DatabaseManagerBiblioteca.trovaAutore(id);
				System.out.println("Autore trovato: " + autore);
				
				if (autore != null) {
					model.addAttribute("autore", autore);
					model.addAttribute("successoMsg", "Autore trovato");
				} else {
					model.addAttribute("erroreMsg", "Autore non trovato, hai messo una id valida?");
				}
			} catch (NumberFormatException e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: l'id inserito non � un numero");
				System.out.println("Eccezione!");
				e.printStackTrace();
			} catch (Exception e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
				System.out.println("Eccezione!");
				e.printStackTrace();
			}
			
		} else if (( (String) request.getParameter("submit") ).equals("modifica")) {
			
			try {
				String dataNascita = request.getParameter("dataNascita");
				String dataMorte = request.getParameter("dataMorte");
				
				Autore autore = new Autore();
				autore.setId(Integer.valueOf(request.getParameter("id")));
				autore.setNome(request.getParameter("nome"));
				autore.setCognome(request.getParameter("cognome"));
				autore.setBiografia(request.getParameter("biografia"));
				autore.setDataNascita(dataNascita.length() > 0 ? Date.valueOf(dataNascita) : null);
				autore.setDataMorte(dataMorte.length() > 0 ? Date.valueOf(dataMorte) : null);
				
				System.out.println("Modifica autore in corso: " + autore);
				DatabaseManagerBiblioteca.modifica(autore);
				System.out.println("Modifica eseguita");
				model.addAttribute("successoMsg", "Autore modificato correttamente. " + autore);
			} catch (Exception e) {
				model.addAttribute("erroreMsg", "Operazione non eseguita: " + e.getMessage());
				System.out.println("Eccezione!");
				e.printStackTrace();
			}
			
		}
	}
}