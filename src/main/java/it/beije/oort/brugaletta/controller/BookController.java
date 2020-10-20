package it.beije.oort.brugaletta.controller;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import it.beije.oort.repository.BookRepository;
import it.beije.oort.brugaletta.entity.Libro;
import it.beije.oort.brugaletta.services.BookService;

@RestController
public class BookController {	
		@Autowired
		private BookRepository bookRepository;
		@Autowired
		private BookService bookService;
	
	
		//restituisce i libri
		@GetMapping("/books")
		public List<Libro> getUsers() {
			List<Libro> books = bookRepository.findAll();
			return books;
		}
		
		//restituisce un libro in base all'id
		@GetMapping("/book/{id}")
		public Libro getUser(@PathVariable int id, Model model) {
			Optional<Libro> book = bookRepository.findById(id);
			return book.get();
		}
		
		//inserisce un nuovo libro
		@PostMapping("/book")
		public Libro insertBook(@RequestBody Libro book, HttpServletRequest request, Model model) {
			bookService.insert(book);
			return book;
		}
		
		//modifica libro in base all'id
		@PutMapping("/book/{id}")
		public Libro utente(@RequestBody Libro book, @PathVariable int id, HttpServletRequest request, Model model) {
			if (book.getId() != 0 && book.getId() != id) {
				throw new IllegalArgumentException("book ID not valid");
			}
			return bookService.update(id, book);
		}
}
