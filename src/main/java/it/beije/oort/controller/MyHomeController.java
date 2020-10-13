package it.beije.oort.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.entity.Utente;
import it.beije.oort.service.UtenteService;
import it.beije.oort.entity.Libro;

@Controller
public class MyHomeController {

	@Autowired
	private UtenteService utenteService;
	
	
	@RequestMapping(value = "/biblioteca/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response,
						Model model, Locale locale) throws IOException {
		String str = login(request, response, model, locale);
		return str;
	}
	

	@RequestMapping(value = "/biblioteca/my_login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response,
						Model model, Locale locale) throws IOException {
		System.out.println("login..." + request.getContextPath());
		
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd - MMMM - yyyy, hh:mm");
		System.out.println(f.format(today));
		model.addAttribute("today", f.format(today));
		model.addAttribute("country", locale.getCountry());
		model.addAttribute("lingua", locale.getLanguage());
		
		model.addAttribute("errore", "");
		
		return "biblioteca/my_login";
	}
	
	
	@RequestMapping(value = "/biblioteca/homepage", method = RequestMethod.GET)
	public String utente(HttpServletRequest request) {
		if (utenteService.isThereUtenteSession(request))
			return "biblioteca/homepage";
		else
			return "biblioteca/my_login";
	}
	

	@RequestMapping(value = "/biblioteca/homepage", method = RequestMethod.POST)
	public String utente(HttpServletRequest request, HttpServletResponse response,
						 Utente u, Model model) {
		System.out.println("utente...");
		Utente utente = null;
		try {
		Optional<Utente> user = utenteService.findByEmailAndPassword(u.getEmail(), u.getPassword());
		System.out.println(user);
		utente = user.get();
		} catch (NoSuchElementException nsee) {
			model.addAttribute("errore", "CREDENZIALI ERRATE");	
			return "biblioteca/my_login";
		}
		if (utente == null) {
			model.addAttribute("errore", "CREDENZIALI ERRATE");	
			return "biblioteca/my_login";
		} else {			
			request.getSession().setAttribute("utente", utente);
			model.addAttribute("utente", utente);	
			return "biblioteca/homepage";
		}
	}
}