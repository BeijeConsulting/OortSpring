//package it.beije.oort.lauria;
//
//import java.time.LocalDateTime;
//import java.util.Locale;
//
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import it.beije.oort.entity.Utente;
//
//
//@Controller
//public class HomeController {
//	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home() {
//		System.out.println("home...");
//		
//		return "home";
//	}
//
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login(HttpServletRequest request, HttpServletResponse response, Model model, Locale locale) {
//		System.out.println("login..." + request.getContextPath());
//		
//		LocalDateTime localDateTime = LocalDateTime.now();
//		
//		model.addAttribute("localDateTime", localDateTime);
//		model.addAttribute("country", locale.getCountry());
//		model.addAttribute("lingua", locale.getLanguage());
//		
//		return "login";
//	}
//
//	@RequestMapping(value = "/utente", method = RequestMethod.GET)
//	public String utente(Model model) {
//		System.out.println("utente...");
//		
//		//carico utente...
//		Utente utente = new Utente();
//		utente.setCognome("Zegna");
//		utente.setNome("Ermenegildo");
//		
//		model.addAttribute("utente", utente);
//		
//		return "utente";
//	}
//	
//	@RequestMapping(value = "/signInUp", method = RequestMethod.GET)
//	public String signInUp(HttpServletRequest request, HttpServletResponse response, Model model) {
//		System.out.println("sign in/up...");
//		//carico utente...
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		
//		Utente utente = new Utente();
//		utente.setCognome("Zegna");
//		utente.setNome("Ermenegildo");
//		
//		request.getSession().setAttribute("utenteSession", utente);
//		
//		model.addAttribute("utente", utente);
//
//		
//		return "signInUp";
//	}
//	
//	@RequestMapping(value = "/confermaLogin", method = RequestMethod.GET)
//	public String confermaLogin(HttpServletRequest request, Model model) {
//		System.out.println("utente...");
//
//		Utente u = (Utente)request.getSession().getAttribute("utenteSession");
////		System.out.println(u);
//		model.addAttribute("utente", u);
////		System.out.println(u);
//		return "confermaLogin";
//	}
//
//
//
//}
