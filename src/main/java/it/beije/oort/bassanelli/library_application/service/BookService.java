package it.beije.oort.bassanelli.library_application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.bassanelli.library_application.repository.BookRepository;

import it.beije.oort.bassanelli.library_application.entity.Book;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
}
