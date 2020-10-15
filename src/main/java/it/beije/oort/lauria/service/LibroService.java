package it.beije.oort.lauria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.lauria.biblioteca.Libro;
import it.beije.oort.lauria.biblioteca.Utente;
import it.beije.oort.lauria.repository.LibroRepository;

@Service
public class LibroService {

	@Autowired
	private LibroRepository libroRepository;
	
	public List<Libro> findAll(){
		
		List<Libro> libri = libroRepository.findByIdGreaterThan(0);
		
		return libri;
		
	}
	
	
	public Libro load(Integer id) {
		
		Optional<Libro> libro = libroRepository.findById(id);
		
		return libro.isPresent() ? libro.get() : null;
		
	}

	
	@Transactional
	public void update(Integer id, Libro datiLibro) {
		
		if (datiLibro == null) {
			throw new IllegalArgumentException("bean libro null");
		}
		
		if (!"".equals(datiLibro.getTitolo()) || datiLibro.getId_autore() > 0 || datiLibro.getId_editore() > 0) {
			
			Libro libro = load(id);
			
			if (libro == null) {
				throw new IllegalArgumentException("non è presente un libro con id " + id);
			}
			
			BeanUtils.copyProperties(datiLibro, libro, "id");
			
			libroRepository.save(libro);
			
		} else throw new IllegalArgumentException("dati libro non presenti");
		
	}

}
