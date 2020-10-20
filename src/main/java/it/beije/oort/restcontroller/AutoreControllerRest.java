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

import it.beije.oort.sb.biblioteca.Autori;
import it.beije.oort.sb.biblioteca.Utenti;
import it.beije.oort.service.AutoriService;

@RestController
@RequestMapping("/api")
public class AutoreControllerRest {
	
	@Autowired
	private AutoriService autoriService;
	
	@GetMapping("/autore")
	public List<Autori> autori() {	
		return autoriService.loadAutori();
	}
	
	@PostMapping("/autore")
	public Autori autore(@RequestBody Autori autore) {
		System.out.println("ricevendo dati autore");
		autoriService.insert(autore);
		return autore;	
	}
	
	@PutMapping("/autore/{id}")
	public Autori autore(@RequestBody Autori autore, @PathVariable Integer id) {
		System.out.println("ricevo dati autore..." + autore);
		
		return autoriService.update(id, autore);
	}
	
	@DeleteMapping("/autore/{id}")
	public String autore(@PathVariable Integer id) {
		return autoriService.deleteById(id);
	}

}
