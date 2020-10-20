package it.beije.oort.gregori.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.gregori.biblioteca.Autore;
import it.beije.oort.gregori.biblioteca.Utente;
import it.beije.oort.gregori.biblioteca.repository.AutoreRepository;

@Service
public class AutoreService {

	@Autowired
	private AutoreRepository autoreRepository;
	
//	Optional<Autore> findById(Integer id);
//	Optional<Autore> find(Autore autore);
//	List<Autore> findAll(Autore autore);
//	Optional<Autore> update(Integer id, Autore autore);
//	Optional<Autore> insert(Autore autore);
//	void delete(Autore autore);
//	void delete(Integer id);
	
	public Autore findById(Integer id) {
		Optional<Autore> autore = autoreRepository.findById(id);
		
		return autore.isPresent() ? autore.get() : null;
	}
	
	public Autore find(Autore autore) {
		Optional<Autore> a = autoreRepository.find(autore);
		
		return a.isPresent() ? a.get() : null;
	}
	
	public List<Autore> findAll() {
		return autoreRepository.findAll();
	}
	
	
	public Autore update(Integer id, Autore autore) {
		if(autore == null) {
			throw new IllegalArgumentException("Bean autore is null");
		}
		
		Autore a = this.find(autore);
		
		if(a == null) {
			throw new IllegalArgumentException("Non è presente un autore con id " + id);
		}
		
		BeanUtils.copyProperties(autore, a, "id");
		
		autoreRepository.save(autore);
		
		return a;
	}
	
	public void insert(Autore autore) {
		if(autore == null) {
			throw new IllegalArgumentException("Bean autore null");
		}
		
		autoreRepository.save(autore);
	}
	
}
