package it.beije.oort.controller;

import java.time.LocalDateTime;
import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.entity.Utente;


@Controller
public class HomeController {

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
//		System.out.println("login..." + request.getContextPath());
//		
//		LocalDateTime localDateTime = LocalDateTime.now();
//		
//		model.addAttribute("localDateTime", localDateTime);
//		model.addAttribute("country", locale.getCountry());
//		model.addAttribute("lingua", locale.getLanguage());
//		
//		return "login";
//	}

//	@RequestMapping(value = "/utente", method = RequestMethod.GET)
//	public String utente(Model model) {
//		System.out.println("utente...");
//		
//		//carico utente...
//		Utente utente = new Utente();
//		utente.setCognome("Zegna");
//		utente.setNome("Ermenegildo");
//		
//		model.addAttribute("utente", utente);
//		
//		return "utente";
//	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		System.out.println("home...");
		
		return "home";
	}
	
	@RequestMapping(value = "/inserimento", method = RequestMethod.GET)
	public String inserimento() {
		System.out.println("inserimento...");
		
		return "inserimento";
	}
	
	@RequestMapping(value = "/visualizza", method = RequestMethod.GET)
	public String visualizza() {
		System.out.println("visualizza...");
		
		return "visualizza";
	}
	
	@RequestMapping(value = "/modifica", method = RequestMethod.GET)
	public String modifica() {
		System.out.println("modifica...");
		
		return "modifica";
	}

}
