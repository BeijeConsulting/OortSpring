package it.beije.oort.sala.restcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.beije.oort.sala.beans.Utente;
import it.beije.oort.sala.controller.services.UtenteService;

@RestController
@RequestMapping(value="/api")
public class ApiController {

	@Autowired
	private UtenteService utenteService;
	
	@RequestMapping(value = "/utenti", method = RequestMethod.GET)
	public List<Utente> utenti(){
		List<Utente> utenti = utenteService.getAll();
		return utenti;	
	}
	
	@RequestMapping(value="/utente/{id}", method = RequestMethod.GET)
	public Utente utente(@PathVariable Integer id) {
		return utenteService.get(id);
	}
	
	@PostMapping("/utente")
	public Utente utente(@RequestBody Utente utente, HttpServletRequest request, Model model) {
		return utenteService.insert(utente);
	}
	
	@PutMapping("/utente/{id}")
	public Utente utente(@RequestBody Utente utente,@PathVariable Integer id, HttpServletRequest request) {
		if(id==null) throw new IllegalArgumentException();
		return utenteService.update(utente, id);
	}
}
