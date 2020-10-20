package it.beije.oort.bassanelli.library_application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.bassanelli.library_application.entity.Author;
import it.beije.oort.bassanelli.library_application.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public Author load(Integer id) {
		
		Optional<Author> author = authorRepository.findById(id);
		
		return author.isPresent() ? author.get() : null;
		
	}
	
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	public String getAuthorNominative(Integer id) {
		Optional<Author> author = authorRepository.findById(id);

		if (author.isPresent()) {
			
			StringBuilder nominative = new StringBuilder();
			nominative.append(author.get().getName()).append(" ").append(author.get().getSurname());
			return nominative.toString();
			
		} else {
			
			return null;
		}
	}
	
	
}
