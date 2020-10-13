package it.beije.oort.gregori.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
