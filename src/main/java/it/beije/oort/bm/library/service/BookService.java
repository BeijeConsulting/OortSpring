package it.beije.oort.bm.library.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.beije.oort.bm.library.entity.Book;
import it.beije.oort.bm.library.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	public List<Book> getAll(){
		return bookRepo.findAll();
	}
}
