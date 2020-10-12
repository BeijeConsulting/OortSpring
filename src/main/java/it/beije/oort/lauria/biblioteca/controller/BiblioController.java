package it.beije.oort.lauria.biblioteca.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.lauria.biblioteca.JPADBtools;
import it.beije.oort.lauria.biblioteca.entity.Autore;
import it.beije.oort.lauria.biblioteca.entity.Editore;
import it.beije.oort.lauria.biblioteca.entity.Libro;
import it.beije.oort.lauria.biblioteca.entity.Utente;



@Controller
public class BiblioController {
	
	@RequestMapping(value = "/biblio/home_biblio", method = RequestMethod.GET)
	public String home() {
		System.out.println("home get...");
		
		return "/biblio/home_biblio";
	}
	
	
	@RequestMapping(value = "/biblio/conferma_login", method = RequestMethod.POST)
	public String confermaLogin(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		System.out.println("conferma login post...");
		//carico utente...
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Utente utente = JPADBtools.verifyUtenti(email, password);
		model.addAttribute("utente", utente);
		if(utente != null) {
			System.out.println("ok");
			
			return "/biblio/conferma_login";
//			request.getSession().setAttribute("userBean", utente);
//			response.sendRedirect("confermaLogin.jsp");
		}else {
//			model.addAttribute("errore", "CREDENZIALI ERRATE");
//			return "login_biblio";
			System.out.println("non c'è");
			System.out.println("utente: "+utente);
			request.getSession().setAttribute("errore", "CREDENZIALI ERRATE");
			model.addAttribute("errore", "CREDENZIALI ERRATE");
			return "/biblio/login_biblio";
		}
		
//		Utente utente = new Utente();
//		utente.setCognome("Zegna");
//		utente.setNome("Ermenegildo");
//		
//		request.getSession().setAttribute("utenteSession", utente);
//		
//		model.addAttribute("utente", utente);
//

	}

	@RequestMapping(value = "/biblio/conferma_login", method = RequestMethod.GET)
	public String confermaLogin(HttpServletRequest request, Model model) {
		System.out.println("conferma login get...");

		return "/biblio/conferma_login";
	}


	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("logout get...");
		request.getSession().invalidate();
		return "/biblio/home_biblio";
	}
}
