package it.beije.oort.lauria.biblioteca;

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



@Controller
public class BiblioController {
	
	@RequestMapping(value = "/home_biblio", method = RequestMethod.GET)
	public String home() {
		System.out.println("home get...");
		
		return "home_biblio";
	}
	
	@RequestMapping(value = "/login_biblio", method = RequestMethod.GET)
	public String loginBiblioget(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("login_biblio get...");
		
		return "login_biblio";
	}
	
	@RequestMapping(value = "/login_biblio", method = RequestMethod.POST)
	public String loginBiblio(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("login_biblio post...");
		//carico utente...
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Utente utente = JPADBtools.verifyUtenti(email, password);
		model.addAttribute("utente", utente);
		if(utente != null) {
			
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
	}

	
	@RequestMapping(value = "/conferma_login", method = RequestMethod.POST)
	public String confermaLogin(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		System.out.println("conferma login post...");
		//carico utente...
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Utente utente = JPADBtools.verifyUtenti(email, password);
		model.addAttribute("utente", utente);
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

	@RequestMapping(value = "/registrazione_nuovo_utente", method = RequestMethod.GET)
	public String registrazioneNuovoUtente() {
		System.out.println("registrazione_nuovo_utente get...");
		
		return "registrazione_nuovo_utente";
	}
	@RequestMapping(value = "/registrazione_nuovo_utente", method = RequestMethod.POST)
	public String registrazioneNuovoUtente(Utente newUtente, HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("registrazione_nuovo_utente post...");
		System.out.println("nuovo utente nome "+newUtente.getNome());
//		model.addAttribute("newUtente", newUtente);
//		Utente utente = (Utente) model.getAttribute("newUtente");
//		JPADBtools.insertUtente(utente.getNome(), utente.getCognome(), utente.getCodice_fiscale(), utente.getEmail(), utente.getTelefono(), utente.getIndirizzo());
		JPADBtools.insertUtente(newUtente.getNome(), newUtente.getCognome(), newUtente.getCodice_fiscale(), newUtente.getEmail(), newUtente.getTelefono(), newUtente.getIndirizzo());
//		model.addAttribute("utente", utente);
		return "conferma_login";

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("logout get...");
		request.getSession().invalidate();
		return "home_biblio";
	}
	@RequestMapping(value = "/visualizza_libri", method = RequestMethod.GET)
	public String visualizzaLibri(Utente utente, HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("visual libri get...");
		List<Libro> libri = JPADBtools.selectLibri();
		model.addAttribute("libri", libri);
		//request.getSession().setAttribute("catalogoLibri", libri);
		List<Autore> autori = JPADBtools.selectAutori();
		model.addAttribute("autori", autori);
		//request.getSession().setAttribute("catalogoAutori", autori);
		List<Editore> editori = JPADBtools.selectEditori();
		model.addAttribute("editori", editori);
		//request.getSession().setAttribute("catalogoEditori", editori);
		request.getSession().getAttribute("utente");
		System.out.println(utente.getNome());
		return "visualizza_libri";
	}
}
