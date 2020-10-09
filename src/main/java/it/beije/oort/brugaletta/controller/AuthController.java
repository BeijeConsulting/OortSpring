package it.beije.oort.brugaletta.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.oort.brugaletta.db.JPDBUtilities;
import it.beije.oort.brugaletta.entity.User;

@Controller
public class AuthController {
	@GetMapping("/")
	public String home() {
		return "home_page";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login_biblio";
	}
	
	@GetMapping("/registrazione")
	public String showSignInForm() {
		return "registrazione_biblio";
	}
	
	@PostMapping("/homepage")
	public String login(@RequestParam String email, @RequestParam String password, Model model, HttpServletRequest request) {
		User loggedUser;
		String path = null;
		if(JPDBUtilities.checkLogin(email, password)) {
			loggedUser = JPDBUtilities.exportLoggedUser(email, password);
			model.addAttribute("loggedUser", loggedUser);
			request.getSession().setAttribute("loggedUser", loggedUser);
			if (loggedUser.isAdmin()) {
				path = "admin_biblio_homepage";
			} else {
				path = "user_biblio_homepage";
			}
		}
		return path;
	}
}
