package it.beije.oort.madonia.biblioteca.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.madonia.biblioteca.ebeans.Libro;
import it.beije.oort.madonia.biblioteca.ebeans.Prestito;
import it.beije.oort.madonia.biblioteca.repository.LibroRepository;
import it.beije.oort.madonia.biblioteca.utilities.EbeanUtils;
import it.beije.oort.madonia.biblioteca.utilities.GeneralUtils;

@Service
public class LibroService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private LibroRepository libroRepository;
	
	public Libro trova(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("La id è un valore null");
		}
		
		Optional<Libro> libro = libroRepository.findById(id);
		return libro.isPresent() ? libro.get() : null;
	}
	
	public Libro trova(String id) {
		if (GeneralUtils.stringIsNullOrEmpty(id)) {
			throw new IllegalArgumentException("La id è null o vuota");
		}
		
		return this.trova(Integer.valueOf(id));
	}
	
	public List<Libro> trovaTutti() {
		return libroRepository.findAll();
	}
	
	@Transactional
	public Libro inserisci(Libro libro) {
		log.debug("Inserimento libro in corso");
		if (libro == null) {
			log.error("Libro non inserito nel database: null");
			throw new IllegalArgumentException("Il libro è un valore null");
		}
		
		if (EbeanUtils.libroIsEmpty(libro)) {
			log.debug("Libro non inserito nel database: vuoto");
			throw new IllegalArgumentException("Il libro deve avere almeno un campo con un valore non vuoto");
		}
		
		return libroRepository.saveAndFlush(libro);
	}
	
	@Transactional
	public Libro modifica(Integer id, Libro datiLibro) {
		log.debug("Modifica libro in corso");
		if (datiLibro == null) {
			log.error("Libro non inserito nel database: null");
			throw new IllegalArgumentException("Il libro è un valore null");
		}
		
		if (EbeanUtils.libroIsEmpty(datiLibro)) {
			throw new IllegalArgumentException("Il libro deve avere almeno un campo con un valore non vuoto");
		}
		
		Libro libro = this.trova(id);
		
		if (libro == null) {
			log.debug("Non è presente alcun libro con la id " + id);
			throw new IllegalArgumentException("Non è presente alcun libro con la id " + id);
		}
		
		BeanUtils.copyProperties(datiLibro, libro, "id");
		return libroRepository.saveAndFlush(libro);
	}
	
	public Libro modifica(String id, Libro datiLibro) {
		if (GeneralUtils.stringIsNullOrEmpty(id)) {
			throw new IllegalArgumentException("La id è null o vuota");
		}
		
		return this.modifica(Integer.valueOf(id), datiLibro);
	}
	
	@Transactional
	public void cancella(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("La id è un valore null");
		}
		
		libroRepository.deleteById(id);
	}
	
	public void cancella(String id) {
		if (GeneralUtils.stringIsNullOrEmpty(id)) {
			throw new IllegalArgumentException("La id è null o vuota");
		}
		
		this.cancella(Integer.parseInt(id));
	}

	public Map<Integer, String> generaMappaTitoli(List<Prestito> listaPrestiti) {
		Map<Integer, String> mappaTitoli = new HashMap<Integer, String>();

		for(Prestito prestito : listaPrestiti) {
			if ( prestito.getIdLibro() == null || mappaTitoli.containsKey(prestito.getIdLibro())) { continue; }

			Libro libro = this.trova(prestito.getIdLibro());
			if (libro != null) {
				mappaTitoli.put(prestito.getIdLibro(), libro.getTitolo());
			}
		}
		
		return mappaTitoli;
	}
}
