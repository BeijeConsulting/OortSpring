package it.beije.oort.madonia.biblioteca.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Utente;
import it.beije.oort.madonia.biblioteca.service.UtenteService;
import it.beije.oort.madonia.db.DatabaseManagerBiblioteca;

@Controller
public class LoginController {
	
	@Autowired
	private UtenteService utenteService;
	
	@RequestMapping(value = "/biblioteca/login", method = RequestMethod.GET)
	public String loginBiblioteca() {
		System.out.println("login biblioteca [GET]...");
		
		return "biblioteca/login";
	}
	
	@RequestMapping(value = "/biblioteca/login", method = RequestMethod.POST)
	public String loginBiblioteca(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		System.out.println("login biblioteca [POST]...");
		String page = "";
		Utente utente = utenteService.login(request.getParameter("email"), request.getParameter("password"));
//		Utente utente = DatabaseManagerBiblioteca.login(request.getParameter("email"), request.getParameter("password"));
		
		if (utente != null) {
			request.getSession().setAttribute("utenteAttivo", utente);
			if (utente.isAdmin()) {
				page = "/biblioteca/inserimento_autore";
				response.sendRedirect("./inserimento_autore");
			} else {
				page = "/biblioteca/prestiti";
				response.sendRedirect("./prestiti");
			}
		} else {
			model.addAttribute("erroreMsg", "Credenziali errate");
			page = "biblioteca/login";
		}
		
		return page;
	}
}
