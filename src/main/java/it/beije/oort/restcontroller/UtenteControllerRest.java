package it.beije.oort.restcontroller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.beije.oort.sb.biblioteca.Utenti;

import it.beije.oort.service.UtentiService;

@RestController
@RequestMapping("/api")
public class UtenteControllerRest {
	
	@Autowired
	private UtentiService utentiService;

	@GetMapping("/utente")
	public List<Utenti> utenti() {	
		return utentiService.loadUtenti();
	}
	
	@PostMapping("/utente")
	public Utenti utente(@RequestBody Utenti utente) {
		System.out.println("ricevendo dati utente");
		utentiService.insert(utente);
		return utente;
		
	}
	
	@PutMapping("/utente/{id}")
	public Utenti utente(@RequestBody Utenti utente, @PathVariable Integer id) {
		System.out.println("ricevo dati utente..." + utente);
		
		return utentiService.update(id, utente);
	}
	
	@DeleteMapping("/utente/{id}")
	public String utente(@PathVariable Integer id) {
		return utentiService.deleteById(id);
	}

}
