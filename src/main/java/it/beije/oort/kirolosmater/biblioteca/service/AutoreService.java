package it.beije.oort.kirolosmater.biblioteca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.kirolosmater.biblioteca.model.Autore;
import it.beije.oort.kirolosmater.biblioteca.repository.AutoreRepository;

@Service
public class AutoreService {
	
	@Autowired
	private AutoreRepository autoreRepository;
	
	public Autore load(Integer id) {
		
		Optional<Autore> autore = autoreRepository.findById(id);
		
		return autore.isPresent() ? autore.get() : null;
		
	}

}
