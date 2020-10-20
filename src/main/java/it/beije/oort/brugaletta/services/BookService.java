package it.beije.oort.brugaletta.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.beije.oort.brugaletta.entity.Libro;
import it.beije.oort.brugaletta.entity.User;
import it.beije.oort.repository.BookRepository;


@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
	public List<Libro> showBooks() {
		List<Libro> books = bookRepository.findAll();
		return books;
	}
	
	@Transactional
	public void insert(Libro book) {
		if (book == null) {
			throw new IllegalArgumentException("libro non esistente");
		}
		bookRepository.save(book);
	}
	
	@Transactional
	public Libro update(int id, Libro bookData) {
		if (bookData == null) {
			throw new IllegalArgumentException("bookData is null");
		}
		Optional<Libro> book = bookRepository.findById(id);
		if (book == null) {
			throw new IllegalArgumentException("A user with id " + id + " doesn't exist");
		}
		BeanUtils.copyProperties(bookData, book.get(), "id");
		return bookRepository.save(book.get());
	}
}