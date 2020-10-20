//package it.beije.oort.ivo.rest;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.MediaType;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import it.beije.oort.entity.Utente;
//import it.beije.oort.repository.UtenteRepository;
//import it.beije.oort.service.UtenteService;
//
//
//@RestController
//public class UserController {
//	
//	@Autowired
//	private UtenteService utenteService;
//
//	@Autowired
//	private UtenteRepository utenteRepository;
//
//	
//	@RequestMapping(value = "/utenti", method = RequestMethod.GET)
//	public List<Utente> getUtenti() {
//		
//		List<Utente> utenti = utenteRepository.findAll();
//		
//		System.out.println("utenti : " + utenti);
//		
//		return utenti;		
//	}
//	
//	@RequestMapping(value = "/utente/{id}", method = RequestMethod.GET)
//	public Utente utente(@PathVariable Integer id, Model model) {
//		System.out.println("utente : " + id);
//		
//		Utente utente = utenteService.load(id);
//		
//		return utente;
//	}
//
//	//@RequestMapping(value = "/utente", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//	@PostMapping("/utente")
//	public Utente utente(@RequestBody Utente utente, HttpServletRequest request, Model model) {
//		System.out.println("ricevo dati utente..." + utente);
//		
//		utenteService.insert(utente);
//		
//		return utente;
//	}
//
//	@PutMapping("/utente/{id}")
//	public Utente utente(@RequestBody Utente utente, @PathVariable Integer id, HttpServletRequest request, Model model) {
//		System.out.println("ricevo dati utente..." + utente);
//		
//		if (utente.getId() != null && utente.getId() != id) {
//			throw new IllegalArgumentException("ID NON VALIDO!!!");
//		}
//		
//		return utenteService.update(id, utente);
//	}
//
//	@DeleteMapping("/utente/{id}")
//	public String utente(@PathVariable Integer id) {
//		System.out.println("cancello utente..." + id);
//		
//		Utente u = utenteService.load(id);
//		
//		if (u != null) {
//			utenteRepository.delete(u);
//			
//			return "cancellato? true";
//		} else {
//			throw new IllegalArgumentException("NESSUN UTENTE CON ID " + id);
//		}
//		
//	}
//
//}
