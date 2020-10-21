package it.beije.oort.sala.controller.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.sala.beans.Libro;
import it.beije.oort.sala.beans.Utente;
import it.beije.oort.sala.controller.repositories.LibroRepository;

@Service
public class LibroService {

	@Autowired 
	private LibroRepository libroRepository;

	public Libro get(Integer id) {
		Optional<Libro> o =libroRepository.findById(id);
		return o.isPresent() ? o.get() : null;
	}

	public List<Libro> getAll() {
		return libroRepository.findAll();
	}

	@Transactional
	public Libro insert(Libro l) {
		if(l!=null && isValid(l)) {
			libroRepository.save(l);
		}
		return l;
	}

	@Transactional
	public void delete(Integer id) {
		libroRepository.deleteById(id);
	}

	@Transactional
	public void update(String field, String value, Integer id) {	
		Libro old = get(id);
		if(old!=null) {
			setField(old, field, value);
			libroRepository.save(old);
		} else {
			throw new IllegalArgumentException("Non Ã¨ presente un prestito con id: " + id);
		}
	}
	
	@Transactional
	public Libro update(Libro libro, Integer id) {
		
		if (libro == null) {
			throw new IllegalArgumentException("bean libro null");
		}
		
		if (!"".equals(libro.getTitolo()) && libro.getIdAutore()!=null) {
			
			Libro old = get(id);
			
			if (old == null) {
				throw new IllegalArgumentException("non è presente un libro con id " + id);
			}
			
			BeanUtils.copyProperties(libro, old, "idLibro");
			
			libroRepository.save(old);
			
			return old;
			
		} else throw new IllegalArgumentException("dati libro non presenti");
	}

	private boolean isValid(Libro l) {
		boolean valid = false;
		if(l.getTitolo()!=null && !(l.getTitolo().equals("")) && l.getIdAutore()!=null) {
			valid=true;
		}
		return valid;
	}

	public void setField(Libro p, String field, String value) {
		switch(field) {
		case "idAutore":
			p.setIdAutore(Integer.parseInt(value));
			break;
		case "idEditore":
			p.setIdEditore(Integer.parseInt(value));
			break;
		case "anno":
			p.setAnno(Short.parseShort(value));
			break;
		case "titolo":
			p.setTitolo(value);
			break;
		case "descrizione":
			p.setDescrizione(value);
			break;
		}
	}
}