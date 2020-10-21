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

import it.beije.oort.madonia.biblioteca.ebeans.Autore;
import it.beije.oort.madonia.biblioteca.service.AutoreService;

@RestController
@RequestMapping(value = "/api")
public class AutoreController {

	@Autowired
	private AutoreService autoreService;
	
	@GetMapping("/autori")
	public List<Autore> getAutori() {
		return autoreService.trovaTutti();
	}
	
	@GetMapping("/autore/{id}")
	public Autore getAutore(@PathVariable Integer id) {
		return autoreService.trova(id);
	}
	
	@PostMapping("/autore")
	public Autore postAutore(@RequestBody Autore autore) {
		return autoreService.inserisci(autore);
	}
	
	@PutMapping("/autore/{id}")
	public Autore putAutore(@PathVariable Integer id, @RequestBody Autore autore) {
		return autoreService.modifica(id, autore);
	}
	
	@DeleteMapping("/autore/{id}")
	public void deleteAutore(@PathVariable Integer id) {
		autoreService.cancella(id);
	}
}
