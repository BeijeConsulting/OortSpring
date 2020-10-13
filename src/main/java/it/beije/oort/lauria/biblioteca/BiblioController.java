package it.beije.oort.lauria.biblioteca;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.lauria.biblioteca.JPADBtools;
import it.beije.oort.lauria.biblioteca.Autore;
import it.beije.oort.lauria.biblioteca.Editore;
import it.beije.oort.lauria.biblioteca.Libro;
import it.beije.oort.lauria.biblioteca.Utente;



@Controller
public class BiblioController {
	
	@RequestMapping(value = "/home_biblio", method = RequestMethod.GET)
	public String home() {
		System.out.println("home get...");
		
		return "home_biblio";
	}
	
	
	@RequestMapping(value = "/conferma_login", method = RequestMethod.POST)
	public String confermaLogin(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		System.out.println("conferma login post...");
		//carico utente...
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Utente utente = JPADBtools.verifyUtenti(email, password);
		request.getSession().setAttribute("userBean", utente);
		//model.addAttribute("utente", utente);
		if(utente != null) {
			System.out.println("ok");
			
			return "conferma_login";
//			request.getSession().setAttribute("userBean", utente);
//			response.sendRedirect("confermaLogin.jsp");
		}else {
//			model.addAttribute("errore", "CREDENZIALI ERRATE");
//			return "login_biblio";
			System.out.println("non c'è");
			System.out.println("utente: "+utente);
			request.getSession().setAttribute("errore", "CREDENZIALI ERRATE");
			model.addAttribute("errore", "CREDENZIALI ERRATE");
			return "login_biblio";
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

	@RequestMapping(value = "/conferma_login", method = RequestMethod.GET)
	public String confermaLogin(HttpServletRequest request, Model model) {
		System.out.println("conferma login get...");

		return "conferma_login";
	}


	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("logout get...");
		request.getSession().invalidate();
		return "home_biblio";
	}
}
