package it.beije.oort.bm.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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
		return data.isPresent() ? data.get() : null;
	}

	public Author addAuthor(Author author) {
		return authorRepo.save(author);
	}

	public Author updateAuthor(int id, Author author) {
		Optional<Author> optSaved = authorRepo.findById(id);
		Author saved = null;
		if(optSaved.isPresent()) {
			saved = optSaved.get();
			BeanUtils.copyProperties(author, saved);
			authorRepo.save(saved);
		}
		return saved;
	}

	public boolean deleteAuthor(int id) {
		boolean ret = false;
		if(authorRepo.findById(id).isPresent()) {
			authorRepo.deleteById(id);
			ret = true;
		}
		return ret;
	}
}
