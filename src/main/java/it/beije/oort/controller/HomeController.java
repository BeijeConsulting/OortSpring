//package it.beije.oort.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//
//@Controller
//public class HomeController {
//
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home() {
//		return "index";
//	}
//		log.trace("home...");
//		log.debug("home...");
//		log.info("home...");
//		log.warn("home...");
//		log.error("home...");
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
//	public String utente() {
//		System.out.println("utente...");
//
//		return "form_utente";
//	}
//
////	@RequestMapping(value = "/utente", method = RequestMethod.POST)
////	public String utente(Utente utente, HttpServletRequest request, Model model) {//@RequestParam String cognome
////		System.out.println("ricevo dati utente...");
////
//////		Utente utente = new Utente();
//////		utente.setCognome(cognome);
//////		utente.setNome(request.getParameter("nome"));
//////		utente.setEmail(request.getParameter("email"));
//////		utente.setTelefono(request.getParameter("telefono"));
////
////		utenteService.insert(utente);
////
////		model.addAttribute("utente", utente);
////
////		return "utente";
////	}
////
////	@RequestMapping(value = "/utente/{id}", method = RequestMethod.GET)
////	public String utente(@PathVariable Integer id, Model model) {
////		System.out.println("utente : " + id);
////
////		//carico utente...
//////		Utente utente = new Utente();
//////		utente.setCognome("Zegna");
//////		utente.setNome("Ermenegildo");
////
////		Utente utente = utenteService.load(id);
////
////		//String nominativo = utenteService.getNominativo(utente);
////
////		model.addAttribute("utente", utente);
////		//model.addAttribute("nominativo", nominativo);
////
////		return "utente";
////	}
//
//	@PostMapping(value = "/")
//    public String redirect(){
//	    return home();
//    }
//}
