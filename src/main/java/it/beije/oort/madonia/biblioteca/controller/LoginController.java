package it.beije.oort.madonia.biblioteca.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.madonia.biblioteca.ebeans.Utente;
import it.beije.oort.madonia.db.DatabaseManagerBiblioteca;

@Controller
public class LoginController {
	@RequestMapping(value = "/biblioteca/login", method = RequestMethod.GET)
	public String loginBiblioteca() {
		System.out.println("login biblioteca [GET]...");
		
		return "biblioteca/login";
	}
	
	@RequestMapping(value = "/biblioteca/login", method = RequestMethod.POST)
	public String loginBiblioteca(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		System.out.println("login biblioteca [POST]...");
		String page = "";
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Utente utente = DatabaseManagerBiblioteca.login(email, password);
		
		if (utente != null) {
			request.getSession().setAttribute("utenteAttivo", utente);
			if (utente.isAdmin()) {
				// TODO inserire pagina tramite metodo
				page = "/biblioteca/inserimento_autore";
				response.sendRedirect("biblioteca/inserimento_autore");
			} else {
				page = "/biblioteca/prestiti";
				response.sendRedirect("./prestiti");
			}
		} else {
			model.addAttribute("erroreMsg", "Credenziali errate.");
			page = "biblioteca/login";
		}
		
		return page;
	}
}
