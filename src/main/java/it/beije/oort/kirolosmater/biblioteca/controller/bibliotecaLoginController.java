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
	private UtenteBibliotecaService utenteBibliotecaService;
	
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
	public String login(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
		HttpSession session = request.getSession();
		String returnPath = "";
		
		System.out.println("entra nel controller");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UtenteBiblioteca user = utenteBibliotecaService.checkLogin(email, password);
		if(user!=null) {
			session.setAttribute("name", user.getNome());
			session.setAttribute("surname", user.getCognome());
			session.setAttribute("userid", user.getId());
			session.setAttribute("auth", true);
			returnPath = "biblioteca/areaPersonale";
		} else {
			model.addAttribute("error", "ERROR: Email or password incorrect");
			returnPath = "biblioteca/bibliotecaLogin";
		}
		
		return returnPath;
	}
	
	
	
	
}
