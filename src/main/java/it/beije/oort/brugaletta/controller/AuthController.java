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
	
	@GetMapping("/registrazione")
	public String showSignInForm() {
		return "registrazione_biblio";
	}
	
	@PostMapping("/homepage")
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
		} catch (NullPointerException e) {
			model.addAttribute("errore", "credenziali errate!");
			path = "login_biblio";
		}
		return path;
	}
}
