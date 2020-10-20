package it.beije.oort.bm.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.bm.library.entity.Book;
import it.beije.oort.bm.library.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	public List<Book> getAll(){
		return bookRepo.findAll();
	}
	
	@Transactional
	public Book addBook(Book b) {
		return bookRepo.save(b);
	}
	
	@Transactional
	public boolean deleteBook(int book_id) {
		boolean ret = false;
		if(bookRepo.findById(book_id).isPresent()) {
			bookRepo.deleteById(book_id);
			ret = true;
		}
		return ret;
	}
	public Book getBook(int id) {
		Optional<Book> book = bookRepo.findById(id);
		return book.isPresent() ? book.get() : null;
	}
	@Transactional
	public Book updateBook(int id, Book book) {
		Optional<Book> optSaved = bookRepo.findById(id);
		Book saved = null;
		if(optSaved.isPresent()) {
			saved = optSaved.get();
			BeanUtils.copyProperties(book, saved);
			bookRepo.save(saved);
		}
		return saved;
	}
}
