package it.beije.oort.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.sb.biblioteca.Utenti;
import it.beije.oort.sb.jpa.JPDBtools;

@Controller
public class LoginController {
	
	@RequestMapping(value="/Login", method = RequestMethod.GET)
	public String loginG() {				
		return "loginsb";
	}

	@RequestMapping(value="/Login", method = RequestMethod.POST)
	public String loginP(HttpServletRequest request, Model model) {				
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		Utenti utente = JPDBtools.ricercaUtente(email, password);
		if(utente==null) {
			model.addAttribute("errore", "Credenziali Errate");
			return "loginsb";
		}
		else { 
			session.setAttribute("utente", utente);
			session.setAttribute("login", "true");
			if(utente.isAdmin()) session.setAttribute("admin", "on");
			else session.setAttribute("admin", "off");
			return "menubiblioteca";				
			}
			
	}
	
	@RequestMapping(value="/Logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("login");
		return "menubiblioteca";
	}

}
