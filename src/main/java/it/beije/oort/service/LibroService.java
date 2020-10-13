package it.beije.oort.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.entity.Libro;
import it.beije.oort.repository.LibroRepository;

@Service
public class LibroService {

	@Autowired
	private LibroRepository libroRepository;
	
	
	public List<Libro> catalogoLibro() {
		List<Libro> libri = libroRepository.findByIdAfter(0);
		return libri;
	}
	
	public Libro libroId(Integer id) {
		Optional<Libro> libro = libroRepository.findById(id);
		return libro.isPresent() ? libro.get() : null;
	}
	
	public List<Libro> cercaTitolo(String titolo) {
		titolo += "%";
		List<Libro> libro = libroRepository.findByTitoloLike(titolo);
		return libro;
	}

}
