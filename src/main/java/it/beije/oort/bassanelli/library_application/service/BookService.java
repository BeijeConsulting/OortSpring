package it.beije.oort.bassanelli.library_application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.bassanelli.library_application.repository.BookRepository;
import it.beije.oort.bassanelli.library_application.entity.Author;
import it.beije.oort.bassanelli.library_application.entity.Book;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public Book load(Integer id) {
		
		Optional<Book> book = bookRepository.findById(id);
		
		return book.isPresent() ? book.get() : null;
		
	}
	
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	public String getBookTitle(Integer id) {
		
		Optional<Book> book = bookRepository.findById(id);
		
		return book.isPresent() ? book.get().getTitle() : null;
	}
	
}
