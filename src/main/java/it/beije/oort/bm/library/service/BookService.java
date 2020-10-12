package it.beije.oort.bm.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.beije.oort.bm.library.database.ConcreteDatabase;
import it.beije.oort.bm.library.database.Database;
import it.beije.oort.bm.library.entity.Book;

@Service
public class BookService {

	private static Database db = ConcreteDatabase.getDatabase();

	public List<Book> getAll(){
		return db.getAll(Book.class);
	}
}
