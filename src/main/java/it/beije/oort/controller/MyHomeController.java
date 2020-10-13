package it.beije.oort.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
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
	//posso collegare due controller alla stessa @Service?
	
	public static boolean isThereUtenteSession (HttpServletRequest request) {
		Utente utenteSession = (Utente)request.getSession().getAttribute("utente");
		return (utenteSession != null);
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
		if (MyHomeController.isThereUtenteSession(request))
			return "biblioteca/homepage";
		else
			return "biblioteca/my_login";
	}
	

	@RequestMapping(value = "/biblioteca/homepage", method = RequestMethod.POST)
	public String utente(HttpServletRequest request, HttpServletResponse response,
						 Utente u, Model model) {
		System.out.println("utente...");

		Optional<Utente> user = utenteService.findByEmailAndPassword(u.getEmail(), u.getPassword());
		Utente utente = user.get();
		System.out.println(utente);

		if (utente == null) {
			model.addAttribute("errore", "CREDENZIALI ERRATE");	
			return "biblioteca/my_login";
		} else {			
			request.getSession().setAttribute("utente", utente);
			model.addAttribute("utente", utente);	
			return "biblioteca/homepage";
		}
	}

//	@RequestMapping(value = "/biblioteca/visualizza_catalogo", method = RequestMethod.GET)
//	public String catalogo(HttpServletRequest request, HttpServletResponse response) {
//
//		String jpql = "SELECT c FROM Libro as c";
//		
//		request.getSession().setAttribute("arraylist", (ArrayList)listLibri);
//		return "biblioteca/visualizza_catalogo";
//	}
//	
//	
//	@RequestMapping(value = "/biblioteca/libro_id", method = RequestMethod.GET)
//	public String libroId(HttpServletRequest request, HttpServletResponse response,
//						 String stringId, Model model) {
//		Libro libro = new Libro();
//		System.out.println(stringId);
//
//		model.addAttribute("libro", libro);
//		if (stringId == null || stringId.equals("")) {
//			System.out.println("null");
//
//			model.addAttribute("errore", "");	
//			return "biblioteca/libro_id";
//		} else {
//			try {
//				System.out.println("try");
//
//				int id = Integer.parseInt(stringId);			
//				//SELECT
//				libro = entityManager.find(Libro.class, id);
//				
//				if (libro == null) {
//					model.addAttribute("errore", "L'id non corrisponde a nessun libro");	
//					return "biblioteca/libro_id";
//				}
//				System.out.println(libro);
//				model.addAttribute("libro", libro);
//				return "biblioteca/libro_id";
//			} catch (NumberFormatException nfe) {
//				model.addAttribute("errore", "L'id inserito non è valido");	
//				return "biblioteca/libro_id";
//			}
//		}
//	}
}
