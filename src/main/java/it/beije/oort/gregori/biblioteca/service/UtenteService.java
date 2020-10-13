package it.beije.oort.gregori.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.oort.gregori.biblioteca.Utente;
import it.beije.oort.gregori.biblioteca.repository.UtenteRepository;

@Service
public class UtenteService {
	
	@Autowired
	private UtenteRepository utenteRepository;

	
	public Utente findByEmailAndPassword(String email, String password) {
		
		Optional<Utente> utente = utenteRepository.findByEmailAndPassword(email, password);
		
		return utente.isPresent() ? utente.get() : null;
	}
	
	public List<Utente> view() {
		return utenteRepository.findAll();
	}
	
	public Utente findByEmail(String email) { 
		Optional<Utente> utente = utenteRepository.findByEmail(email);	
		
		return utente.isPresent() ? utente.get() : null;
	}
	
	@Transactional
	public void insert(Utente utente) {
		if (utente == null) {
			throw new IllegalArgumentException("bean utente null");
		}
		
		if (!"".equals(utente.getCognome()) || !"".equals(utente.getNome()) ||
			!"".equals(utente.getEmail()) || !"".equals(utente.getTelefono())) {
			
			utenteRepository.save(utente);
			
		} 
		else {
			throw new IllegalArgumentException("dati utente non presenti");
		}
		
	}
	
	@Transactional
	public void update(Integer id, Utente datiUtente) {
		
		if (datiUtente == null) {
			throw new IllegalArgumentException("bean utente null");
		}
		
		if (!"".equals(datiUtente.getCognome()) || !"".equals(datiUtente.getNome()) ||
			!"".equals(datiUtente.getEmail()) || !"".equals(datiUtente.getTelefono())) {
			
			Utente utente = load(id);
			
			if (utente == null) {
				throw new IllegalArgumentException("non è presente un utente con id " + id);
			}
			
			BeanUtils.copyProperties(datiUtente, utente, "id");
			
			utenteRepository.save(utente);
			
		} else throw new IllegalArgumentException("dati utente non presenti");
		
	}
	
	public Utente load(Integer id) {
		
		Optional<Utente> utente = utenteRepository.findById(id);
		
		return utente.isPresent() ? utente.get() : null;
		
	}
	
	
}
