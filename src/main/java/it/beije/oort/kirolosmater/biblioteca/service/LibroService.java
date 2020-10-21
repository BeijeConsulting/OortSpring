package it.beije.oort.kirolosmater.biblioteca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.kirolosmater.biblioteca.model.Libro;
import it.beije.oort.kirolosmater.biblioteca.repository.LibroRepository;

@Service
public class LibroService {

	@Autowired
	private LibroRepository libroRepository;
	
	public Libro load(Integer id) {
		
		Optional<Libro> libro = libroRepository.findById(id);
		
		return libro.isPresent() ? libro.get() : null;
		
	}
}
