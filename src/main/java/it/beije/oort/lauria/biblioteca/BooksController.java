package it.beije.oort.lauria.biblioteca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.beije.oort.lauria.service.LibroService;

@RestController
public class BooksController {
	
	@Autowired
	private LibroService libroService;
	
	@RequestMapping(value = "/books_list", method = RequestMethod.GET)
	public List<Libro> getBooks() {
		
		List<Libro> libri = libroService.findAll();
		return libri;
	}
	
	@RequestMapping(value = "/books_list/{id}", method = RequestMethod.GET)
	public Libro getSingleBook(@PathVariable Integer id) {
		System.out.println("Libro : " + id);
		
		Libro libro = libroService.load(id);
		
		return libro;
	}

	//@RequestMapping(value = "/books_list", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/books_list")
	public Libro insertNewBook(@RequestBody Libro libro) {
		System.out.println("ricevo dati libro..." + libro);
		
		libroService.insert(libro);
		
		return libro;
	}

	@PutMapping("/books_list/{id}")
	public Libro modifyBook(@RequestBody Libro libro, @PathVariable Integer id) {
		System.out.println("ricevo dati libro..." + libro.toString());
		
		if (libro.getId() != null && libro.getId() != id) {
			throw new IllegalArgumentException("id mismatch");
		}
		
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
