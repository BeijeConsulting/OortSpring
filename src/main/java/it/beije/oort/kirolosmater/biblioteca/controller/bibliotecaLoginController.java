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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.oort.entity.Utente;
import it.beije.oort.kirolosmater.biblioteca.model.Prestito;
import it.beije.oort.kirolosmater.biblioteca.model.UtenteBiblioteca;
import it.beije.oort.kirolosmater.biblioteca.service.UtenteBibliotecaService;

@Controller
@RequestMapping("/biblioteca")
public class bibliotecaLoginController {
	
	@Autowired
	private static UtenteBibliotecaService utenteBibliotecaService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String bibliotecaLogin(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		System.out.println("login..." + request.getContextPath());
		
		LocalDateTime localDateTime = LocalDateTime.now();
		
		model.addAttribute("localDateTime", localDateTime);
		model.addAttribute("country", locale.getCountry());
		model.addAttribute("lingua", locale.getLanguage());
		
		return "biblioteca/bibliotecaLogin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String bibliotecaLogin(@RequestParam String email, @RequestParam String password, HttpServletRequest request, Model model) {
		return checkUserWithQueryMethods(email, password, request, model);
	}
	
	public static String checkUserWithSession (String email, String password, HttpServletRequest request, Model model) {
		System.out.println("ricevo dati utente...");
		String stringaOutput = "biblioteca/areaPersonale";
		HttpSession session = request.getSession();
		System.out.println(email);
		UtenteBiblioteca utente = checkEmail(email);
		
		boolean passwordCorretta = checkPassword(utente, password);
		if (passwordCorretta) {
			session.setAttribute("userBean", utente);
			model.addAttribute("utente", utente);
			List<Prestito> prestitiUtente = visualizzaPrestitiByIdUtente(utente);
			session.setAttribute("prestitiUserBean", prestitiUtente);
			model.addAttribute("prestitiUtente", prestitiUtente);
			boolean admin = utente.isAdmin();
			session.setAttribute("userIsAdmin", admin);
			model.addAttribute("admin", admin);
			stringaOutput = "biblioteca/areaPersonale";
		} else {
			session.setAttribute("errore", "CREDENZIALI ERRATE");
			model.addAttribute("errore", "CREDENZIALI ERRATE");
			stringaOutput = "biblioteca/bibliotecaLogin";
		}
		
		
		return stringaOutput;
	}
	
	public static String checkUserWithQueryMethods(String email, String password, HttpServletRequest request, Model model) {
		System.out.println("ricevo dati utente...");
		String stringaOutput = "biblioteca/areaPersonale";
//		System.out.println(email);
		UtenteBiblioteca utente1 = utenteBibliotecaService.findByNome("kirolos").get(0);
		UtenteBiblioteca utente = utenteBibliotecaService.findByEmail(email);
		
		boolean passwordCorretta = checkPassword(utente, password);
		if (passwordCorretta) {
			model.addAttribute("utente", utente);
			List<Prestito> prestitiUtente = visualizzaPrestitiByIdUtente(utente);
			model.addAttribute("prestitiUtente", prestitiUtente);
			boolean admin = utente.isAdmin();
			model.addAttribute("admin", admin);
			stringaOutput = "biblioteca/areaPersonale";
		} else {
			model.addAttribute("errore", "CREDENZIALI ERRATE");
			stringaOutput = "biblioteca/bibliotecaLogin";
		}
		
		
		return stringaOutput;
	}
}
