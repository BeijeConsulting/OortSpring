package it.beije.oort.lauria.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.oort.lauria.biblioteca.Libro;
import it.beije.oort.lauria.service.LibroService;

@RestController
public class BooksController {
		
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LibroService libroService;
	
	
	//@RequestMapping(value = "/books_list", method = RequestMethod.GET)
	@GetMapping("/books_list")
	public List<Libro> getBooks() {
		
		List<Libro> libri = libroService.findAll();
		return libri;
	}
	
	@GetMapping("/books_list/{id}")
	public Libro getSingleBook(@PathVariable Integer id) {
		System.out.println("Libro : " + id);
		
		Libro libro = libroService.load(id);
		
		return libro;
	}

	//@RequestMapping(value = "/books_list", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/books_list")
	public Libro insertNewBook(@RequestBody Libro libro) {
		System.out.println("ricevo dati libro..." + libro);
		
		try{
			libroService.insert(libro);
			return libro;
		}catch(IllegalArgumentException e) {
			log.debug(e.getMessage());
			return null;		
		}
		
	}

	@PutMapping("/books_list/{id}")
	public Libro modifyBook(@RequestBody Libro libro, @PathVariable Integer id) {
		System.out.println("ricevo dati libro..." + libro.toString());
		
//		if (libro.getId() != null && libro.getId() != id) {
//			throw new IllegalArgumentException("id mismatch");
//		}		
		
		return libroService.update(id, libro);
	}

	@DeleteMapping("/books_list/{id}")
	public String deleteBook(@PathVariable Integer id) {
		System.out.println("cancello libro..." + id);
		
		try{
			libroService.delete(id);
			return "book successfully deleted";
		}catch(IllegalArgumentException e) {
			return e.getMessage();
		}
	}

}
