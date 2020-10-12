package it.beije.oort.bm.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.beije.oort.bm.library.database.ConcreteDatabase;
import it.beije.oort.bm.library.database.Database;
import it.beije.oort.bm.library.entity.Publisher;

@Service
public class PublisherService {

	private static Database db = ConcreteDatabase.getDatabase();

	public List<Publisher> getAll(){
		return db.getAll(Publisher.class);
	}
}
