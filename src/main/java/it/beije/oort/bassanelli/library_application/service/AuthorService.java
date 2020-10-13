package it.beije.oort.bassanelli.library_application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.bassanelli.library_application.entity.Author;
import it.beije.oort.bassanelli.library_application.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}
	
}
