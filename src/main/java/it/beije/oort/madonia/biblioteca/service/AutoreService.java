package it.beije.oort.madonia.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.madonia.biblioteca.ebeans.Autore;
import it.beije.oort.madonia.biblioteca.repository.AutoreRepository;
import it.beije.oort.madonia.biblioteca.utilities.EbeanUtils;
import it.beije.oort.madonia.biblioteca.utilities.GeneralUtils;

@Service
public class AutoreService {

	@Autowired
	private AutoreRepository autoreRepository;
	
	public Autore trova(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("La id è un valore null");
		}
		
		Optional<Autore> autore = autoreRepository.findById(id);
		return autore.isPresent() ? autore.get() : null;
	}
	
	public Autore trova(String id) {
		if (GeneralUtils.stringIsNullOrEmpty(id)) {
			throw new IllegalArgumentException("La id è null o vuota");
		}
		
		return this.trova(Integer.valueOf(id));
	}
	
	public List<Autore> trovaTutti() {
		return autoreRepository.findAll();
	}
	
	@Transactional
	public Autore inserisci(Autore autore) {
		if (autore == null)
			throw new IllegalArgumentException();
		
		if (EbeanUtils.autoreIsEmpty(autore)) {
			throw new IllegalArgumentException("L'autore deve avere almeno un campo con un valore non vuoto");
		}
		
		return autoreRepository.saveAndFlush(autore);
	}
	
	@Transactional
	public Autore modifica(Integer id, Autore datiAutore) {
		if (datiAutore == null) {
			throw new IllegalArgumentException("L'autore è un valore null");
		}
		
		if (EbeanUtils.autoreIsEmpty(datiAutore)) {
			throw new IllegalArgumentException("L'autore deve avere almeno un campo con un valore non vuoto");
		}
		
		Autore autore = this.trova(id);
		
		if (autore == null) {
			throw new IllegalArgumentException("Non è presente alcun autore con la id " + id);
		}
		
		BeanUtils.copyProperties(datiAutore, autore, "id");
		return autoreRepository.saveAndFlush(autore);
	}
	
	public Autore modifica(String id, Autore datiAutore) {
		if (GeneralUtils.stringIsNullOrEmpty(id)) {
			throw new IllegalArgumentException("La id è null o vuota");
		}
		
		return this.modifica(Integer.valueOf(id), datiAutore);
	}
	
	@Transactional
	public void cancella(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("La id è un valore null");
		}
		
		autoreRepository.deleteById(id);
	}
	
	public void cancella(String id) {
		if (GeneralUtils.stringIsNullOrEmpty(id)) {
			throw new IllegalArgumentException("La id è null o vuota");
		}
		
		this.cancella(Integer.parseInt(id));
	}
}
