package it.beije.oort.lauria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.lauria.biblioteca.Libro;
import it.beije.oort.lauria.repository.LibroRepository;

@Service
public class LibroService {

	@Autowired
	private LibroRepository libroRepository;
	
	public List<Libro> findAll(){
		
		List<Libro> libri = libroRepository.findByIdGreaterThan(0);
		
		return libri;
		
	}
}
