package it.beije.oort.brugaletta.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.beije.oort.brugaletta.entity.User;
import it.beije.oort.brugaletta.services.UserService;

@Controller
@Scope("session")
public class AuthController {
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
	public String home() {
		return "home_page";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login_biblio";
	}
	
	@GetMapping("/signin")
	public String showSignInForm() {
		return "registrazione_biblio";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, Model model, HttpServletRequest request) {
		User loggedUser = userService.login(email, password);
		String path = null;
		try {
			if(loggedUser.isAdmin()) {
				path = "admin_biblio_homepage";
			} else {
				path = "user_biblio_homepage";
			}
			model.addAttribute("loggedUser", loggedUser);
			request.getSession().setAttribute("loggedUser", loggedUser);
		} catch (NullPointerException e) {
			model.addAttribute("errore", "credenziali errate!");
			return showLogin();
		}
		return path;
	}
	
	@PostMapping("/signin")
	public String signIn(User utente, Model model) {
		userService.insert(utente);
		try {
			if (utente.getCognome().equals("") || utente.getNome().equals("") || utente.getEmail().equals("") || utente.getPassword().equals("")) {
				throw new Exception();
			} else {
				model.addAttribute("confermaRegistrazione", "La tua registrazione è andata a buon fine!");
			}
		} catch (Exception e) {
			model.addAttribute("errore", "Inserire i campi obbligatori!");
			return showSignInForm();
		}
		return showLogin();
	}
}
