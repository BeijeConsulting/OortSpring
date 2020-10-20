package it.beije.oort.restcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.beije.oort.entity.Libro;
import it.beije.oort.repository.LibroRepository;
import it.beije.oort.service.LibroService;

@RestController
@RequestMapping("/rest")
public class BookController {

	@Autowired
	private LibroService libroService;

	@Autowired
	private LibroRepository libroRepository;

	
	@RequestMapping(value = "/libri", method = RequestMethod.GET)
	public List<Libro> getLibri() {
		
		List<Libro> libri = libroRepository.findAll();
		
		System.out.println("utenti : " + libri);
		
		return libri;		
	}
	
	@RequestMapping(value = "/libro/{id}", method = RequestMethod.GET)
	public Libro libro(@PathVariable Integer id, Model model) {
		System.out.println("libro : " + id);
		
		Libro libro = libroService.libroId(id);
		
		return libro;
	}

	//INSERT
//	@RequestMapping(value = "/libro", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/libro")
	public Libro libro(@RequestBody Libro libro, HttpServletRequest request, Model model) {
		System.out.println("ricevo dati libro..." + libro);
		
		libroService.insert(libro);
		
		return libro;
	}

	//UPDATE
	@PutMapping("/libro/{id}")
	public Libro libro(@RequestBody Libro libro, @PathVariable Integer id, HttpServletRequest request, Model model) {
		System.out.println("ricevo dati utente..." + libro);
		
		if (libro.getId() != null && libro.getId() != id) {
			throw new IllegalArgumentException("ID NON VALIDO!!!");
		}
		
		return libroService.update(id, libro);
	}
	
	//REPLACE
	@PutMapping("/libro/replace/{id}")
	public Libro libroReplace(@RequestBody Libro libro, @PathVariable Integer id, HttpServletRequest request, Model model) {
		System.out.println("ricevo dati utente..." + libro);
		
		if (libro.getId() != null && libro.getId() != id) {
			throw new IllegalArgumentException("ID NON VALIDO!!!");
		}
		
		return libroService.replace(id, libro);
	}

	//DELETE
	@DeleteMapping("/libro/{id}")
	public String libro(@PathVariable Integer id) {
		System.out.println("cancello libro..." + id);
		
		Libro libro = libroService.libroId(id);
		
		if (libro != null) {
			libroRepository.delete(libro);
			
			return "cancellato? true";
		} else {
			throw new IllegalArgumentException("NESSUN LIBRO CON ID " + id);
		}
		
	}
}
