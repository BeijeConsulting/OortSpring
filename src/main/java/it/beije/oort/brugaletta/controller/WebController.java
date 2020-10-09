package it.beije.oort.brugaletta.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	@GetMapping("/")
	public String home() {
		return "home_page";
	}
	
	@GetMapping("/login_biblio")
	public String showLogin() {
		return "login_biblio";
	}
	
	@GetMapping("/registrazione_biblio")
	public String showSignInForm() {
		return "registrazione_biblio";
	}
	
//	
//	@RequestMapping(value = "/", method = RequestMethod.POST) 
//	public String login() {
//		return "";
//	}
}
