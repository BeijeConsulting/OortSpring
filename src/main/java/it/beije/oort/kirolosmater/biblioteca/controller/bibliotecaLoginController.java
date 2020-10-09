package it.beije.oort.kirolosmater.biblioteca.controller;

import static it.beije.oort.kirolosmater.biblioteca.MetodiPrestito.visualizzaPrestitiByIdUtente;
import static it.beije.oort.kirolosmater.biblioteca.MetodiUtente.checkEmail;
import static it.beije.oort.kirolosmater.biblioteca.MetodiUtente.checkPassword;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.oort.kirolosmater.biblioteca.model.Prestito;
import it.beije.oort.kirolosmater.biblioteca.model.Utente;

@Controller
public class bibliotecaLoginController {
	
	@RequestMapping(value = "/biblioteca/login", method = RequestMethod.GET)
	public String bibliotecaLogin(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		System.out.println("login..." + request.getContextPath());
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		model.addAttribute("localDateTime", localDateTime);
		model.addAttribute("country", locale.getCountry());
		model.addAttribute("lingua", locale.getLanguage());
		
		return "biblioteca/bibliotecaLogin";
	}

	@RequestMapping(value = "/biblioteca/login", method = RequestMethod.POST)
	public String bibliotecaLogin(@RequestParam String email, @RequestParam String password, HttpServletRequest request, Model model) {
		System.out.println("ricevo dati utente...");
		String stringaOutput = "biblioteca/areaPersonale";
		HttpSession session = request.getSession();
		System.out.println(email);
		Utente utente = checkEmail(email);
		
		boolean passwordCorretta = checkPassword(utente, password);
		if (passwordCorretta) {
			session.setAttribute("userBean", utente);
			List<Prestito> prestitiUtente = visualizzaPrestitiByIdUtente(utente);
			session.setAttribute("prestitiUserBean", prestitiUtente);
			boolean admin = utente.isAdmin();
			session.setAttribute("userIsAdmin", admin);
			stringaOutput = "biblioteca/areaPersonale";
		} else {
			session.setAttribute("errore", "CREDENZIALI ERRATE");
			model.addAttribute("errore", "CREDENZIALI ERRATE");
			stringaOutput = "biblioteca/bibliotecaLogin";
		}
		model.addAttribute("utente", utente);
		return stringaOutput;
	}
}
