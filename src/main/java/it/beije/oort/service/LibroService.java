package it.beije.oort.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.entity.Libro;
import it.beije.oort.repository.LibroRepository;

@Service
public class LibroService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

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
	
	public List<Libro> libroIdAutore(Integer id_autore) {
		List<Libro> libri = libroRepository.findByIdAutore(id_autore);
		return libri;
	}
	
	public List<Libro> cercaTitolo(String titolo) {
		titolo += "%";
		List<Libro> libro = libroRepository.findByTitoloLike(titolo);
		return libro;
	}
	
	
	//@Transactional
	public void insert(Libro libro) {
		if (libro == null) {
			throw new IllegalArgumentException("bean libro null");
		}
		if (!"".equals(libro.getTitolo()) || !"".equals(libro.getIdAutore().toString()) ||
				!"".equals(libro.getIdEditore().toString()) ) {
	
			libroRepository.save(libro);
			log.info("utente inserito!");
		} else throw new IllegalArgumentException("dati libro non presenti");
	}
	
	
//	@Transactional
	public Libro replace(Integer id, Libro datiLibro) {
		if (datiLibro == null) {
			throw new IllegalArgumentException("bean libro null");
		}
		if (!"".equals(datiLibro.getTitolo()) || !"".equals(datiLibro.getIdAutore().toString()) ||
				!"".equals(datiLibro.getIdEditore().toString()) ) {
			
			Libro libro = libroId(id);
			
			if (libro == null) {
				throw new IllegalArgumentException("non è presente un libro con id " + id);
			}
			//update (replace)
			BeanUtils.copyProperties(datiLibro, libro, "id"); //attenzione!! fa il replace!
			libroRepository.save(libro);
			
			return libro;
			
		} else throw new IllegalArgumentException("dati libro non presenti");
	}
	
	
	public Libro update(Integer id, Libro datiLibro) {
		if (datiLibro == null) {
			throw new IllegalArgumentException("bean libro null");
		}
		Libro libro = libroId(id);
		if (libro == null) {
			throw new IllegalArgumentException("non è presente un libro con id " + id);
		}
		
		//dal momento che potrebbe prendere i dati in posti che non siano il form, 
		//è necessario un ulteriore verifica: verifico che i campi non siano null.
		if (datiLibro.getTitolo() != null && !"".equals(datiLibro.getTitolo()) ) 
			libro.setTitolo(datiLibro.getTitolo());
		
		if (datiLibro.getIdAutore() != null && !"".equals(datiLibro.getIdAutore().toString()) ) 
			libro.setIdAutore(datiLibro.getIdAutore());
		
		if (datiLibro.getIdEditore() != null && !"".equals(datiLibro.getIdEditore().toString()) ) 
			libro.setIdEditore(datiLibro.getIdEditore());

		if (datiLibro.getDescrizione() != null && !"".equals(datiLibro.getDescrizione()) ) 
			libro.setDescrizione(datiLibro.getDescrizione());

		if (datiLibro.getAnno() != null && !"".equals(datiLibro.getAnno().toString()) ) 
			libro.setAnno(datiLibro.getAnno());
			
		//update 
		libroRepository.save(libro);
		
		return libro;
	}

}
