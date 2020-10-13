package it.beije.oort.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.oort.repository.UtentiRepository;
import it.beije.oort.sb.biblioteca.Utenti;

@Service
public class UtentiService {

	@Autowired
	private UtentiRepository utentiRepository;
	
	public List<Utenti> loadUtenti(){
		return utentiRepository.findAll();
	}
	
	public Utenti check(String email, String password) {
		Optional<Utenti> utente = utentiRepository.findByEmailAndPassword(email, password);
		return utente.isPresent() ? utente.get() : null;
	}
}
