package it.beije.oort.bm.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.beije.oort.bm.library.database.old.ConcreteDatabase;
import it.beije.oort.bm.library.database.old.Database;
import it.beije.oort.bm.library.entity.Author;

@Service
public class AuthorService {

	private static Database db = ConcreteDatabase.getDatabase();

	public List<Author> getAll(){
		return db.getAll(Author.class);
	}
}
