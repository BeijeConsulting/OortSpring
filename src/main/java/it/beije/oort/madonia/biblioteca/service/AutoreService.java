package it.beije.oort.madonia.biblioteca.service;

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
	
	@Transactional
	public void inserisci(Autore autore) {
		if (autore == null)
			throw new IllegalArgumentException();
		
		if (EbeanUtils.autoreIsEmpty(autore)) {
			throw new IllegalArgumentException("L'autore deve avere almeno un campo con un valore non vuoto");
		}
		
		autoreRepository.saveAndFlush(autore);
	}
	
	@Transactional
	public void modifica(Integer id, Autore datiAutore) {
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
		autoreRepository.saveAndFlush(autore);
	}
	
	public void modifica(String id, Autore datiAutore) {
		if (GeneralUtils.stringIsNullOrEmpty(id)) {
			throw new IllegalArgumentException("La id è null o vuota");
		}
		
		this.modifica(Integer.valueOf(id), datiAutore);
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
