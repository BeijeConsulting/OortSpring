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

import it.beije.oort.madonia.biblioteca.ebeans.Libro;
import it.beije.oort.madonia.biblioteca.service.LibroService;

@RestController
@RequestMapping(value = "/api")
public class LibroController {
	
	@Autowired
	private LibroService libroService;
	
	@GetMapping("/libri")
	public List<Libro> getLibri() {
		return libroService.trovaTutti();
	}
	
	@GetMapping("/libro/{id}")
	public Libro getLibro(@PathVariable Integer id) {
		return libroService.trova(id);
	}
	
	@PostMapping("/libro")
	public Libro postLibro(@RequestBody Libro libro) {
		return libroService.inserisci(libro);
	}
	
	@PutMapping("/libro/{id}")
	public Libro putLibro(@PathVariable Integer id, @RequestBody Libro libro) {
		return libroService.modifica(id, libro);
	}
	
	@DeleteMapping("/libro/{id}")
	public void deleteLibro(@PathVariable Integer id) {
		libroService.cancella(id);
	}
	
}
