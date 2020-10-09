
package it.beije.oort.gregori.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.oort.gregori.rubrica.db.JPAEntityManager;
import it.beije.oort.gregori.rubrica.db.ReaderDb;
import it.beije.oort.gregori.rubrica.db.WriterDb;
import it.beije.oort.rubrica.Contatto;


@Controller
public class HomeController {
	
	

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
//	@RequestMapping(value = "/utente", method = RequestMethod.POST)
//	public String utente(Utente utente, HttpServletRequest request, Model model) {//@RequestParam String cognome
//		System.out.println("ricevo dati utente...");
//		
////		Utente utente = new Utente();
////		utente.setCognome(cognome);
////		utente.setNome(request.getParameter("nome"));
////		utente.setEmail(request.getParameter("email"));
////		utente.setTelefono(request.getParameter("telefono"));
//		
//		model.addAttribute("utente", utente);
//		
//		return "utente";
//	}
//
//	@RequestMapping(value = "/utente/{id}", method = RequestMethod.GET)
//	public String utente(@PathVariable Integer id, Model model) {
//		System.out.println("utente : " + id);
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
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		System.out.println("home...");
		
		return "home";
	}
	
	@RequestMapping(value = "/visualizza", method = RequestMethod.GET)
	public String visualizza(Model model) {
		System.out.println("visualizza...");
		
		List<Contatto> contatti = ReaderDb.readContatti();
		model.addAttribute("contatti", contatti);
		
		return "visualizza";
	}
	
	@RequestMapping(value = "/inserisci", method = RequestMethod.GET)
	public String inserisci() {
		System.out.println("inserisci...");
		
		return "inserisci";
	}
	
	@RequestMapping(value = "/inserisci", method = RequestMethod.POST)
	public String inserisci(Contatto contatto, Model model) {
		System.out.println("inserisci after inserimento...");
		
		List<Contatto> contatti = new ArrayList<Contatto>();
		contatti.add(contatto);
		
		WriterDb.writeContatti(contatti);
		
		model.addAttribute("contatto", contatto);
		
		return "inserisci";
	}	
	
	@RequestMapping(value = "/modifica", method = RequestMethod.GET)
	public String modifica(Model model) {
		System.out.println("modifica...");
		
		List<Contatto> contatti = ReaderDb.readContatti();
		model.addAttribute("contatti", contatti);
		
		return "modifica";
	}
	
	@RequestMapping(value = "/modifica", method = RequestMethod.POST)
	public String modifica(@RequestParam(name="selezione-contatto") String selezione_contatto, Contatto contatto, Model model) {
		System.out.println("modifica after modifica...");
		
		if(!selezione_contatto.equals("")) {
			EntityManager entityManager = JPAEntityManager.createEntityManager();
			
			Contatto c = entityManager.find(Contatto.class, Integer.parseInt(selezione_contatto));
			c = contatto;
			
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			entityManager.persist(c);
			entityManager.getTransaction().commit();
			
			entityManager.close();	
		}
		
		model.addAttribute("contatto", contatto);
		
		List<Contatto> contatti = ReaderDb.readContatti();
		model.addAttribute("contatti", contatti);
		
		return "modifica";
	}	
	
	@RequestMapping(value = "/rimuovi", method = RequestMethod.GET)
	public String rimuovi(Model model) {
		System.out.println("rimuovi...");
		
		List<Contatto> contatti = ReaderDb.readContatti();
		model.addAttribute("contatti", contatti);
		
		return "rimuovi";
	}
	
	@RequestMapping(value = "/rimuovi", method = RequestMethod.POST)
	public String rimuovi(@RequestParam(name="selezione-contatto") String selezione_contatto, Model model) {
		System.out.println("rimuovi after rimozione...");
		
		if(!selezione_contatto.equals("")) {
			EntityManager entityManager = JPAEntityManager.createEntityManager();
			
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			
			Contatto contatto = entityManager.find(Contatto.class, Integer.parseInt(selezione_contatto));
	
			entityManager.remove(contatto);
			
			entityManager.getTransaction().commit();
			
			entityManager.close();	
			
			model.addAttribute("contatto", contatto);
		}
	
		List<Contatto> contatti = ReaderDb.readContatti();
		model.addAttribute("contatti", contatti);
		
		return "rimuovi";
	}

}
