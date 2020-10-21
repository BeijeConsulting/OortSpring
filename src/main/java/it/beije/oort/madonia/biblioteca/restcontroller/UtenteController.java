package it.beije.oort.madonia.biblioteca.restcontroller;

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

import it.beije.oort.madonia.biblioteca.ebeans.Utente;
import it.beije.oort.madonia.biblioteca.service.UtenteService;

@RestController
@RequestMapping(value = "/api")
public class UtenteController {

	@Autowired
	private UtenteService utenteService;
	
	@GetMapping("/utenti")
	public List<Utente> getUtenti() {
		return utenteService.trovaTutti();
	}
	
	@GetMapping("/utente/{id}")
	public Utente getUtente(@PathVariable Integer id) {
		return utenteService.trova(id);
	}
	
	@PostMapping("/utente")
	public Utente postUtente(@RequestBody Utente utente) {
		return utenteService.inserisci(utente);
	}
	
	@PutMapping("/utente/{id}")
	public Utente putUtente(@PathVariable Integer id, @RequestBody Utente utente) {
		return utenteService.modifica(id, utente);
	}
	
	@DeleteMapping("/utente/{id}")
	public void deleteUtente(@PathVariable Integer id) {
		utenteService.cancella(id);
	}
}
