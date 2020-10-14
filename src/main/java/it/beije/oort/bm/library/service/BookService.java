package it.beije.oort.bm.library.service;

import java.util.List;
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
	public boolean addBook(Book b) {
		boolean ret = false;
		if(b!=null) {
			bookRepo.save(b);
			ret = true;
		}
		return ret;
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
}
