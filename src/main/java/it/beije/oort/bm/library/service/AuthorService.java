package it.beije.oort.bm.library.service;

import java.util.List;
import java.util.Optional;

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

	public Author getAuthor(int id) {
		Optional<Author> data = authorRepo.findById(id);
		Author ret = data.isPresent() ? data.get() : null;
		return ret;
	}
}
