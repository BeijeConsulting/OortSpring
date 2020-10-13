package it.beije.oort.bm.library.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.beije.oort.bm.library.entity.Author;
import it.beije.oort.bm.library.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepo;

	public List<Author> getAll(){
		return authorRepo.findAll();
	}
}
