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

import it.beije.oort.sb.biblioteca.Libri;
import it.beije.oort.service.LibriService;

@RestController
@RequestMapping("/api")
public class LibroControllerRest {
	
	@Autowired
	private LibriService libriService;
	
	@GetMapping("/libro")
	public List<Libri> autori() {	
		return libriService.loadLibri();
	}
	
	@PostMapping("/libro")
	public Libri libro(@RequestBody Libri libro) {
		System.out.println("ricevendo dati autore");
		libriService.insert(libro);
		return libro;	
	}
	
	@PutMapping("/libro/{id}")
	public Libri libro(@RequestBody Libri libro, @PathVariable Integer id) {
		System.out.println("ricevo dati libro..." + libro);
		
		return libriService.update(id, libro);
	}
	
	@DeleteMapping("/libro/{id}")
	public String libro(@PathVariable Integer id) {
		return libriService.deleteById(id);
	}

}
