package it.beije.oort.sala.controller.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.sala.beans.Libro;
import it.beije.oort.sala.controller.repositories.LibroRepository;

@Service
public class LibroService {

	@Autowired 
	private LibroRepository libroRepository;
	
	public Libro get(Integer id) {
		Optional<Libro> o =libroRepository.findById(id);
		return o.isPresent() ? o.get() : null;
	}
}
