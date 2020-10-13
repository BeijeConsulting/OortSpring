package it.beije.oort.lauria.biblioteca;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.oort.lauria.biblioteca.JPADBtools;
import it.beije.oort.lauria.biblioteca.Utente;
import it.beije.oort.lauria.service.UtenteService;

@Controller
public class LoginController {

	@Autowired
	private UtenteService utenteService;
	
	@RequestMapping(value = "/login_biblio", method = RequestMethod.GET)
	public String loginBiblio() {
		System.out.println("login_biblio get...");
		
		return "login_biblio";
	}
	
	@RequestMapping(value = "/login_biblio", method = RequestMethod.POST)
	public String loginBiblio(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println("login_biblio post...");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
//		Utente utente = JPADBtools.verifyUtenti(email, password);
		
		
		Utente utente = utenteService.findByEmailAndPassword(email, password);
		
		
		
		System.out.println("utente login : " + utente);
//		model.addAttribute("utente", utente);
		if(utente != null) {
			request.getSession().setAttribute("userBean", utente);
			return "conferma_login";
		}else {
			System.out.println("non c'è. utente: "+utente);
			model.addAttribute("errore", "CREDENZIALI ERRATE");
			return "login_biblio";
		}
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

		JPADBtools.insertUtente(newUtente.getNome(), newUtente.getCognome(), 
									newUtente.getCodice_fiscale(), newUtente.getEmail(), 
									newUtente.getTelefono(), newUtente.getIndirizzo(),
									newUtente.getPassword(), false);
		
		request.getSession().setAttribute("userBean", newUtente);
		//model.addAttribute("newUtente", "Utente registrato con successo.");
		return "conferma_login";

	}

}
